package com.example.jun.connection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;

public class Connection implements Closeable {

    private final Logger log = LoggerFactory.getLogger(Connection.class);
    private static final String CONNECTION_STATUS = "연결된 상태";
    private Long id;
    private boolean close;
    private String message;
    private boolean autoCommit;

    public Connection(Long id) {
        this.id = id;
        this.message = CONNECTION_STATUS;
        this.autoCommit = true;
    }

    public String getMessage() {
        return message;
    }

    public boolean isConnected() {
        return this.message.equals(CONNECTION_STATUS);
    }

    public void setAutoCommit(boolean autoCommit) {
        log.info("[Connection] setAutoCommit:{}", autoCommit);
        this.autoCommit = autoCommit;
    }

    @Override
    public void close() {
        log.info("[Connection] 커넥션 반납");
        log.info("[Transaction] 트랜잭션 종료");
        this.close = true;
    }

    @Override
    public String toString() {
        return "Connection=[" +
                "id=" + id +
                ", close=" + close +
                ", message='" + message + '\'' +
                ", autoCommit=" + autoCommit +
                ']';
    }
}
