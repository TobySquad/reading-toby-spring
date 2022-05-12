package com.example.jun.example.threadlocal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomThreadByThreadLocal implements Runnable {

    private final Logger log = LoggerFactory.getLogger(CustomThreadByThreadLocal.class);
    private ConnectionThreadLocal connectionThreadLocal;

    public CustomThreadByThreadLocal(ConnectionThreadLocal connectionThreadLocal) {
        this.connectionThreadLocal = connectionThreadLocal;
    }

    @Override
    public void run() {
        log.info("CustomThread: connectionz={}", connectionThreadLocal);
    }
}
