package com.example.jun.configuration;

import com.example.jun.transaction.transactionmanager.DataSourceTransactionManagerz;
import com.example.jun.transaction.TransactionTemplate;
import com.example.jun.product.repository.ProductRepository;
import com.example.jun.product.service.ProductService;
import com.example.jun.product.service.ProductServiceProxy;
import com.example.jun.product.service.ProductServiceReal;
import com.example.jun.transaction.transactionmanager.TransactionManagerz;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    @Bean
    public ProductService productService() {
        ProductServiceReal productServiceReal = new ProductServiceReal(productRepository(), transactionManagerz());
        return new ProductServiceProxy(productServiceReal);
    }

    @Bean
    public ProductRepository productRepository() {
        return new ProductRepository();
    }

    @Bean
    public TransactionTemplate transactionTemplate() {
        return new TransactionTemplate(transactionManagerz(), productRepository());
    }

    @Bean
    public TransactionManagerz transactionManagerz() {
        return new DataSourceTransactionManagerz();
    }
}
