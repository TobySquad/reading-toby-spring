package com.example.toby.chapter_02;

import java.util.List;

public class UserService {

    public final UserRepository userRepository;
    public final FriendRepository friendRepository;

    public UserService(UserRepository userRepository, FriendRepository friendRepository) {
        this.userRepository = userRepository;
        this.friendRepository = friendRepository;
    }

    public void join(User user) {
        System.out.println("Real UserService join");
        userRepository.join(user);
    }

    public List<User> findAll() {
        System.out.println("Real UserService findAll");
        return userRepository.findAll();
    }
}


