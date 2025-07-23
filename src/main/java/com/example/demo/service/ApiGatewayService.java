package com.example.demo.service;
import com.example.demo.model.apigateway.product.ApiProduct;
import com.example.demo.model.apigateway.product.CreateProduct;
import com.example.demo.model.apigateway.product.ProductPageWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import java.util.Base64;

import org.springframework.web.reactive.function.client.WebClient;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApiGatewayService {

    @Value("${ncp.access-key}")
    private String accessKey;

    @Value("${ncp.secret-key}")
    private String secretKey;

    private static final String BASE_URL = "https://apigateway.apigw.ntruss.com";

    private WebClient webClient = WebClient.builder()
            .baseUrl(BASE_URL)
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build();

    public List<ApiProduct> getAllProducts() {
        String path = "/api/v1/products";
        
        String timestamp = String.valueOf(Instant.now().toEpochMilli());  // toEpochMilli -> 현재시각 밀리초 기준의 타임스탬프변환
        String signature = makeSignature("GET", path, timestamp);

        String rawJson = webClient.get()
                .uri(path)
                .header("x-ncp-iam-access-key", accessKey)
                .header("x-ncp-apigw-timestamp", timestamp)
                .header("x-ncp-apigw-signature-v2", signature)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        System.out.println("응답 원본: " + rawJson);

        ProductPageWrapper response = webClient.get()
                .uri(path)
                .header("x-ncp-iam-access-key", accessKey)
                .header("x-ncp-apigw-timestamp", timestamp)
                .header("x-ncp-apigw-signature-v2", signature)
                .retrieve()
                .bodyToMono(ProductPageWrapper.class)
                .block();

        return response != null && response.getProductPage() != null
                ? response.getProductPage().getContent()
                : Collections.emptyList();
    }

    // PRODUCT 생성
    public ApiProduct createProduct(CreateProduct product) {

        String path = "/api/v1/products";
        String timestamp = String.valueOf(Instant.now().toEpochMilli());
        String signature = makeSignature("POST", path, timestamp);

        return webClient.post()
                .uri(path)
                .header("x-ncp-iam-access-key", accessKey)
                .header("x-ncp-apigw-timestamp", timestamp)
                .header("x-ncp-apigw-signature-v2", signature)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .bodyValue(product)
                .retrieve()
                .bodyToMono(ApiProduct.class)
                .block();
    }

    public void deleteProduct(String productId) {
        String path = "/api/v1/products/" + productId;
        String timestamp = String.valueOf(Instant.now().toEpochMilli());
        String signature = makeSignature("DELETE", path, timestamp);

        webClient.delete()
                .uri(path)
                .header("x-ncp-iam-access-key", accessKey)
                .header("x-ncp-apigw-timestamp", timestamp)
                .header("x-ncp-apigw-signature-v2", signature)
                .retrieve()
                .toBodilessEntity()
                .block();
    }

//    public ApiKey generateApiKeyForProduct(String productId) {
//        String path = "/api/v1/products/" + productId + "/apikeys";
//        String timestamp = String.valueOf(Instant.now().toEpochMilli());
//        String signature = makeSignature("POST", path, timestamp);
//
//        return webClient.post()
//                .uri(path)
//                .header("x-ncp-iam-access-key", accessKey)
//                .header("x-ncp-apigw-timestamp", timestamp)
//                .header("x-ncp-apigw-signature-v2", signature)
//                .retrieve()
//                .bodyToMono(ApiKey.class)
//                .block();
//    }

    private String makeSignature(String method, String url, String timestamp) {
        try {
            String space = " ";
            String newLine = "\n";
            String message = method + space + url + newLine + timestamp + newLine + accessKey;

            SecretKeySpec signingKey = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(signingKey);

            byte[] rawHmac = mac.doFinal(message.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(rawHmac);
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate signature.", e);
        }
    }
}