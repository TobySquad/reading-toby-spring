package com.example.demo.jdbctemplate;

import jdk.jfr.Frequency;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository repository;

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id") Long id) {
        Optional<User> findResult = repository.findById(id);

        if (findResult.isPresent()) return findResult.get();

        throw new IllegalArgumentException("사용자를 찾을 수 없습니다.");
    }

    @GetMapping("/user/new")
    public User addUser(@RequestParam("name") String name) {
        return repository.simpleInsert(new User(name));
    }
}
