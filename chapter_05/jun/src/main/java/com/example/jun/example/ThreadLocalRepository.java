package com.example.jun.example;

import com.example.jun.example.normal.ConnectionNormal;
import com.example.jun.example.threadlocal.ConnectionThreadLocal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicLong;

public class ThreadLocalRepository {

    private final Logger log = LoggerFactory.getLogger(ThreadLocalRepository.class);
    private static final Long BASIC_INDEX = 0L;
    private static final Long ONE_SECOND = 1000L;

    private final AtomicLong idGenerator = new AtomicLong(BASIC_INDEX);

    /**
     * ThreadLocal에 저장되는 값들
     *  @idStore: index
     *  @valueStore: 값
     */
    private ThreadLocal<Long> idStore = new ThreadLocal<>();
    private ThreadLocal<String> valueStore = new ThreadLocal<>();

    private String normalValue;

    public ConnectionThreadLocal getConnectionThreadLocal(String value) {
        idStore.set(idGenerator.incrementAndGet());
        log.info("[값 저장] id= {}, value= {}", idStore.get(), valueStore.get());
        // {1L, null}
        // {2L, null}
        // {3L, null}
        valueStore.set(value);
        sleep(ONE_SECOND);
        ConnectionThreadLocal connectionThreadLocal = new ConnectionThreadLocal(idStore.get(), valueStore.get());
        // {1L, value}
        // {2L, value}
        // {3L, value}
        log.info("[값 조회] Connection: {}", connectionThreadLocal);
        return connectionThreadLocal;
    }

    public ConnectionNormal getConnectionNormal(String value) {
        idStore.set(idGenerator.incrementAndGet());
        log.info("[값 저장] id= {}, value= {}", idStore.get(), normalValue);
        normalValue = value;
        sleep(ONE_SECOND);
        ConnectionNormal connectionNormal = new ConnectionNormal(idStore.get(), normalValue);
        log.info("[값 조회] Connection: {}", connectionNormal);
        return connectionNormal;
    }

    private void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
