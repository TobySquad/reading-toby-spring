package com.example.jun.product.service;

import com.example.jun.product.domain.Product;

public class ProductServiceProxy implements ProductService {

    private final ProductServiceReal productServiceReal;

    public ProductServiceProxy(ProductServiceReal productServiceReal) {
        this.productServiceReal = productServiceReal;
    }

    @Override
    public Product registProduct(String name, Integer price) {
        return productServiceReal.registProduct(name, price);
    }
}
