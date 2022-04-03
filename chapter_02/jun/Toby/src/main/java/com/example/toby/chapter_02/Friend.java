package com.example.toby.chapter_02;

public class Friend {
    private Long id;
    private String name;
    private String loginId;
    private String password;

    public Friend(String name, String loginId, String password) {
        this.id = FriendRepository.getSequence();
        this.name = name;
        this.loginId = loginId;
        this.password = password;
    }

    public Long getId() {
        return id;
    }
}
