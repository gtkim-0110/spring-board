package com.example.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class Menu {
  private Long id;
  private Long pId;
  private String name;
  private String src;
  private Long orderNo;
  private String icon;
  private boolean isActive;
  private Long depth;
  private Date createDt;
  private Date updateDt;
  private String component;
}
