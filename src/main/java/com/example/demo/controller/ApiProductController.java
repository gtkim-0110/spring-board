package com.example.demo.controller;

import com.example.demo.model.apigateway.product.ApiProduct;
import com.example.demo.model.apigateway.product.CreateProduct;
import com.example.demo.service.ApiGatewayService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ApiProductController {

    private final ApiGatewayService apiGatewayService;

    // 🔍 API Gateway에 등록된 Product 목록 조회
    @GetMapping
    public ResponseEntity<List<ApiProduct>> getAllProducts() {
        return ResponseEntity.ok(apiGatewayService.getAllProducts());
    }

    // API Gateway에 등록된 Product 추가
    // ex)
    // http://localhost:8080/api/products
    //  {
    //    "productName": "postmanTest",
    //    "description": "apiDescription",
    //    "subscriptionCode": "protected"
    //  }

    @PostMapping
    public ResponseEntity<ApiProduct> createProduct(@RequestBody CreateProduct product) {
        return ResponseEntity.ok(apiGatewayService.createProduct(product));
    }

    // http://localhost:8080/api/products?productId=5127ey1ls0
    @DeleteMapping
    public void deleteProduct(@RequestParam String productId) {
        apiGatewayService.deleteProduct(productId);
    }

    // 참고 https://apigateway.apigw.ntruss.com/apigw/swagger-ui?productId=mquhyw54kg&apiId=8th0okfj1z&stageId=g80ry4c25q&stageType=default#/

}