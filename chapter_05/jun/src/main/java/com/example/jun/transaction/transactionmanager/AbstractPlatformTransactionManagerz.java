package com.example.jun.transaction.transactionmanager;

import com.example.jun.transaction.definition.TransactionDefinition;
import com.example.jun.transaction.exception.TransactionEx;
import com.example.jun.transaction.status.DefaultTransactionStatus;
import com.example.jun.transaction.status.TransactionStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractPlatformTransactionManagerz implements PlatformTransactionManagerz {

    private final Logger log = LoggerFactory.getLogger(AbstractPlatformTransactionManagerz.class);


    @Override
    public TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionEx {
        log.info("[Transaction] 트랜잭션 시작");
        TransactionStatus status = (definition != null ? new DefaultTransactionStatus() : null);
        if (status == null) {
            rollback(status);
            return null;
        }
        commit(status);
        return status;
    }

    @Override
    public void commit(TransactionStatus status) throws TransactionEx {
        log.info("[Transaction] 트랜잭션 정상. TransactionStatus: {}", status);
    }

    @Override
    public void rollback(TransactionStatus status) throws TransactionEx {
        log.info("[Transaction] 트랜잭션 비정상. TransactionStatus: {}", status);
    }
}
