package com.example.jun.transaction.transactionmanager;

import com.example.jun.connection.*;
import com.example.jun.transaction.definition.TransactionDefinition;
import com.example.jun.transaction.exception.TransactionEx;
import com.example.jun.transaction.status.DefaultTransactionStatus;
import com.example.jun.transaction.status.TransactionStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataSourceTransactionManagerz extends AbstractPlatformTransactionManagerz {

    private final Logger log = LoggerFactory.getLogger(DataSourceTransactionManagerz.class);

    private DataSource dataSource;

    public DataSourceTransactionManagerz() {
        this.dataSource = new JdbcConnectionPool();
    }

    @Override
    public void doBegin(TransactionDefinition definition) {
        // Connection connection = DataSourceUtils.getConnection(dataSource);
        // connection.setAutoCommit(false);
        log.info("[Transaction] 트랜잭션 시작");
    }

    @Override
    public TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionEx {
        log.info("[Transaction] 트랜잭션 시작");
        Connection connection = DataSourceUtils.getConnection(dataSource);
        connection.setAutoCommit(false);
        return (definition != null ? new DefaultTransactionStatus() : null);
    }

    @Override
    public void commit(TransactionStatus status) throws TransactionEx {
        log.info("[Transaction] 정상 트랜잭션 트랜잭션 종료. TransactionStatus: {}", status);
        returnConnection();
    }

    private void returnConnection() {
        TransactionSynchronizationManager synchronizationManager = new TransactionSynchronizationManager();
        synchronizationManager.remove();
    }

    @Override
    public void rollback(TransactionStatus status) throws TransactionEx {
        log.info("[Transaction] 비정상 트랜잭션. 트랜잭션 롤백. TransactionStatus: {}", status);
    }
}
