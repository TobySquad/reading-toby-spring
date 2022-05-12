package com.example.jun.product.controller;

import com.example.jun.product.domain.Product;
import lombok.Getter;

@Getter
public class ProductRegistResponse {
    private Long id;
    private String name;
    private Integer price;

    public ProductRegistResponse(Long id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public ProductRegistResponse(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
    }
}
