package com.example.jun.product.repository;

import com.example.jun.connection.DataSource;
import com.example.jun.connection.JdbcConnectionPool;
import com.example.jun.product.domain.Product;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class ProductRepository {

    private static final Long START_INDEX = 0L;
    private AtomicLong idGenerator = new AtomicLong(START_INDEX);
    private static final Map<Long, Product> repository = new ConcurrentHashMap<>();
    private final DataSource dataSource;

    public ProductRepository() {
        this.dataSource = new JdbcConnectionPool();
    }

    public Product save(Product product) {
        Long id = idGenerator.incrementAndGet();
        Product saveProduct = new Product(id, product.getName(), product.getPrice());
        repository.put(id, saveProduct);
        return saveProduct;
    }
}
