package com.example.demo.model;

import lombok.Data;

@Data
public class Board {
    private Long id;
    private String title;
    private String content;
    private String userId;
    private String status;
    private String image_url;
}