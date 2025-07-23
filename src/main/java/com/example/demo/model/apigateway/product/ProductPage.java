package com.example.demo.model.apigateway.product;

import lombok.Data;

import java.util.List;

@Data
public class ProductPage {
    private List<ApiProduct> content;
    private int total;
}
