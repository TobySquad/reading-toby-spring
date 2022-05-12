package com.example.jun.product.controller;

import com.example.jun.product.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("")
    public ProductRegistResponse registProduct(@RequestBody ProductRegistRequest request) {
        String name = request.getName();
        Integer price = request.getPrice();
        return new ProductRegistResponse(productService.registProduct(name, price));
    }
}
