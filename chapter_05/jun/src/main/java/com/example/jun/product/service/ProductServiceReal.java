package com.example.jun.product.service;

import com.example.jun.product.domain.Product;
import com.example.jun.product.repository.ProductRepository;
import com.example.jun.transaction.TransactionTemplate;
import com.example.jun.transaction.transactionmanager.TransactionManagerz;

public class ProductServiceReal implements ProductService {

    private final ProductRepository productRepository;
    private final TransactionTemplate template;

    public ProductServiceReal(ProductRepository productRepository, TransactionManagerz transactionManagerz) {
        this.productRepository = productRepository;
        this.template = new TransactionTemplate(transactionManagerz, productRepository);
    }

    /**
     * 템플릿 콜백으로 구현해야 하지만
     * 복잡해서 간단히 구현
     */
    @Override
    public Product registProduct(String name, Integer price) {
        return template.execute(new Product(name, price));
    }
}
