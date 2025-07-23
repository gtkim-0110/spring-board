package com.example.demo.model.apigateway.product;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ApiProduct {
    @JsonProperty("productId")
    private String productId;

    @JsonProperty("apiId")
    private String apiId;

    @JsonProperty("apiName")
    private String apiName;

    @JsonProperty("apiDescription")
    private String apiDescription;

    @JsonProperty("tenantId")
    private String tenantId;

    @JsonProperty("modifier")
    private String modifier;

    @JsonProperty("modTime")
    private String modTime; // 필요시 LocalDateTime 으로 변경 가능

    @JsonProperty("isDeleted")
    private boolean isDeleted;

    @JsonProperty("domainCode")
    private String domainCode;

    // Getters, Setters (lombok 사용 시 @Data 또는 @Getter/@Setter)
}