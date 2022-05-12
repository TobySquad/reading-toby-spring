package com.example.jun.example.normal;

public class ConnectionNormal {

    private final Long id;
    private final String value;

    public ConnectionNormal(Long id, String value) {
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
