package com.example.jun.product.controller;

import lombok.Getter;

@Getter
public class ProductRegistRequest {
    private Long id;
    private String name;
    private Integer price;

    public ProductRegistRequest(Long id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public ProductRegistRequest() {
    }
}
