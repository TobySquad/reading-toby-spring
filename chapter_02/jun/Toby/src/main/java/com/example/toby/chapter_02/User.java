package com.example.toby.chapter_02;

public class User {
    private Long id;
    private String name;
    private String loginId;
    private String password;

    public User(String name, String loginId, String password) {
        this.id = UserRepository.getSequence();
        this.name = name;
        this.loginId = loginId;
        this.password = password;
    }

    public Long getId() {
        return id;
    }
}
