package com.example.demo.dto.board;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardCreateRequest {
    private String title;
    private String content;
    private String userId;
    private String status;
    private String image_url;
}