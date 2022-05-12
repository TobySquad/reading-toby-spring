package com.example.jun.transaction.transactionmanager;

import com.example.jun.connection.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TransactionSynchronizationManager {

    private static final Logger log = LoggerFactory.getLogger(TransactionSynchronizationManager.class);
    private static final ThreadLocal<Connection> synchronizations = new ThreadLocal<>();

    public void setConnection(Connection connection) {
        synchronizations.set(connection);
        log.info("[ThreadLocal] 커넥션 저장: {}", synchronizations.get());
    }

    public void remove() {
        synchronizations.remove();
        log.info("[ThreadLocal] 커넥션 종료. 커넥션 반납: {}", synchronizations.get());
    }
}
