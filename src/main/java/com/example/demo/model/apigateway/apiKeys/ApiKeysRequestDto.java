package com.example.demo.model.apigateway.apiKeys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiKeysRequestDto {
    private String apiKeyName;
    private Integer limit;
    private Integer offset;
}
