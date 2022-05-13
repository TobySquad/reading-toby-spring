package com.example.demo.jdbctemplate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private Long id;
    private String name;

    public User(String name) {
        this.name = name;
    }
}
