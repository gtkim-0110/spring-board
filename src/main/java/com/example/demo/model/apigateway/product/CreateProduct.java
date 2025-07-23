package com.example.demo.model.apigateway.product;

import com.example.demo.model.enums.SubscriptionCodeType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CreateProduct {
    @JsonProperty("productName")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("subscriptionCode")
    private SubscriptionCodeType subscriptionCode;  // PROTECTED or public
}
