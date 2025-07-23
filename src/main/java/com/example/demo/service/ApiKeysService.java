package com.example.demo.service;

import com.example.demo.model.ApiKey;
import com.example.demo.model.apigateway.apiKeys.ApiKeyResponseDto;
import com.example.demo.model.apigateway.apiKeys.ApiKeysRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Base64;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApiKeysService {

    @Value("${ncp.access-key}")
    private String accessKey;

    @Value("${ncp.secret-key}")
    private String secretKey;

    private static final String BASE_URL = "https://apigateway.apigw.ntruss.com";

    private WebClient webClient = WebClient.builder()
            .baseUrl(BASE_URL)
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build();

    public List<ApiKey> getAllApiKeys(ApiKeysRequestDto requestDto) {

        String path = "/api/v1/api-keys";
        String fullPath = String.format("/api/v1/api-keys?apiKeyName=%s&limit=%d&offset=%d",
                requestDto.getApiKeyName(),
                requestDto.getLimit(),
                requestDto.getOffset());

        String timestamp = String.valueOf(Instant.now().toEpochMilli());  // toEpochMilli -> 현재시각 밀리초 기준의 타임스탬프변환
        String signature = makeSignature("GET", fullPath, timestamp);

        ApiKeyResponseDto response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(path)
                        .queryParam("apiKeyName", requestDto.getApiKeyName())
                        .queryParam("limit", requestDto.getLimit())
                        .queryParam("offset", requestDto.getOffset())
                        .build()
                )
                .header("x-ncp-iam-access-key", accessKey)
                .header("x-ncp-apigw-timestamp", timestamp)
                .header("x-ncp-apigw-signature-v2", signature)
                .retrieve()
                .bodyToMono(ApiKeyResponseDto.class)
                .block();

        return response != null ? response.getApiKeys() : Collections.emptyList();
    }

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
