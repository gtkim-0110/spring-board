package com.example.demo.controller;

import com.example.demo.model.ApiKey;
import com.example.demo.model.apigateway.apiKeys.ApiKeysRequestDto;
import com.example.demo.service.ApiKeysService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/apiKeys")
@RequiredArgsConstructor
public class ApiKeysController {

    private final ApiKeysService apiKeysService;

    @GetMapping
    public ResponseEntity<List<ApiKey>> getAllApiKeys(ApiKeysRequestDto requestDto) {
        return ResponseEntity.ok(apiKeysService.getAllApiKeys(requestDto));
    }
}
