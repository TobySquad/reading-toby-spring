package com.example.jun.transaction;


import com.example.jun.product.domain.Product;
import com.example.jun.product.repository.ProductRepository;
import com.example.jun.transaction.definition.DefaultTransactionDefinition;
import com.example.jun.transaction.definition.TransactionDefinition;
import com.example.jun.transaction.exception.TransactionEx;
import com.example.jun.transaction.status.TransactionStatus;
import com.example.jun.transaction.transactionmanager.TransactionManagerz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Transactional
 */
public class TransactionTemplate {

    private static final Logger log = LoggerFactory.getLogger(TransactionTemplate.class);

    private final TransactionManagerz transactionManagerz;
    private final ProductRepository productRepository;

    public TransactionTemplate(TransactionManagerz transactionManagerz, ProductRepository productRepository) {
        this.transactionManagerz = transactionManagerz;
        this.productRepository = productRepository;
    }

    /**
     * 트랜잭션의 껍데기를 위한 빈 클래스
     * TransactionDefinition, TransactionStatus
     */
    public Product execute(Product product) {
        TransactionDefinition definition = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManagerz.getTransaction(definition);

        Product savedProduct = null;
        try {
            log.info("[Business] 비즈니스 로직 실행 전, 저장된 값 {}", savedProduct);
            savedProduct = productRepository.save(product);
            log.info("[Business] 비즈니스 로직 실행 후, 저장된 값 {}", savedProduct);
        } catch (TransactionEx ex) {
            transactionManagerz.rollback(status);
            throw ex;
        }
        transactionManagerz.commit(status);
        return savedProduct;
    }
}
