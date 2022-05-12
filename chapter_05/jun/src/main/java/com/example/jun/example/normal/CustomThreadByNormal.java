package com.example.jun.example.normal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomThreadByNormal implements Runnable {

    private final Logger log = LoggerFactory.getLogger(CustomThreadByNormal.class);
    private ConnectionNormal connectionNormal;

    public CustomThreadByNormal(ConnectionNormal connectionNormal) {
        this.connectionNormal = connectionNormal;
    }

    @Override
    public void run() {
        log.info("CustomThread: ={}", connectionNormal);
    }
}
