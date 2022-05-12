package com.example.jun.example.threadlocal;

public class ConnectionThreadLocal {

    private final Long id;
    private final String value;

    public ConnectionThreadLocal(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "[" +
                "id=" + id +
                ", value='" + value + '\'' +
                ']';
    }
}
