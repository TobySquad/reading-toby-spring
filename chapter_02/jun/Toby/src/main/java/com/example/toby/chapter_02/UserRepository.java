package com.example.toby.chapter_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class UserRepository {

    private static final Map<Long, User> repository = new ConcurrentHashMap<>();
    private static final AtomicLong sequence = new AtomicLong(0L);

    public User join(User user) {
        System.out.println("Real UserRepository join");
        repository.put(user.getId(), user);
        return repository.get(user.getId());
    }

    public List<User> findAll() {
        System.out.println("Real UserRepository findAll");
        return new ArrayList<>(repository.values().stream()
                .collect(Collectors.toUnmodifiableList()));
    }

    public void findAllVoid() {
        System.out.println("Real UserRepository findAllVoid");
    }

    public static Long getSequence() {
        return sequence.incrementAndGet();
    }
}




