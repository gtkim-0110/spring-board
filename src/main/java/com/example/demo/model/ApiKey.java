package com.example.demo.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ApiKey {

    @JsonProperty("apiKeyId")
    private String apiKeyId;

    @JsonProperty("apiKey")
    private String apiKey;

    @JsonProperty("apiKeyName")
    private String apiKeyName;

    @JsonProperty("status")
    private String status;

    @JsonProperty("createdAt")
    private String createdAt;
}
