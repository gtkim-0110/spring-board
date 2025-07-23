package com.example.demo.model.apigateway.apiKeys;

import com.example.demo.model.ApiKey;

import java.util.List;

public class ApiKeyResponseDto {
    private List<ApiKey> apiKeys;
    private int total;
    private int initialCount;

    public List<ApiKey> getApiKeys() {
        return apiKeys;
    }
}
