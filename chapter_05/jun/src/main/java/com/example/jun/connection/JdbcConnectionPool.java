package com.example.jun.connection;

import com.example.jun.transaction.transactionmanager.TransactionSynchronizationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class JdbcConnectionPool implements DataSource {

    private static final int START = 1;
    private static final int END = 200;

    private static final Logger log = LoggerFactory.getLogger(JdbcConnectionPool.class);

    private static List<Connection> pool = new LinkedList<>();

    static {
        for (int index = START; index <= END; index++) {
            pool.add(new Connection((long) index));
        }
        log.info("[Connection] 커넥션 생성, Connection: {}개", pool.size());
    }

    @Override
    public Connection getConnection() {
        Collections.shuffle(pool);
        log.info("[Connection] 커넥션 획득");
        Connection connection = pool.stream()
                .filter(Connection::isConnected)
                .findAny()
                .orElseThrow();
        save(connection);
        return connection;
    }

    /**
     * 편의를 위해 TransactionSynchronizationManager에 직접 접근
     * 원래 스프링에선 잘못된 구현.
     */
    private void save(Connection connection) {
        TransactionSynchronizationManager synchronizationManager = new TransactionSynchronizationManager();
        synchronizationManager.setConnection(connection);
    }
}
