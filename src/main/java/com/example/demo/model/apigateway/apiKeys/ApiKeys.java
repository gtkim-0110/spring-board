package com.example.demo.model.apigateway.apiKeys;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ApiKeys {
    @JsonProperty("productId")
    private String apiKeyDescription;

    @JsonProperty("productId")
    private String apiKeyId;

    @JsonProperty("productId")
    private String apiKeyName;

    @JsonProperty("productId")
    private String domainCode;

    @JsonProperty("productId")
    private Boolean isEnabled;

    @JsonProperty("productId")
    private String modTime;

    @JsonProperty("productId")
    private String modifier;

    @JsonProperty("productId")
    private String primaryKey;

    @JsonProperty("productId")
    private String secondaryKey;

    @JsonProperty("productId")
    private String tenantId;
}
