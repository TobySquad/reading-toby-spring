package com.example.demo.scope;

public enum ScopeType {
    SINGLETON("singleton"),
    PROTOTYPE("prototype"),
    REQUEST("request"),
    SESSION("session"),
    APPLICATION("application");

    private String type;

    private ScopeType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
