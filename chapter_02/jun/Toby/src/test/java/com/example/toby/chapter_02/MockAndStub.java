package com.example.toby.chapter_02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

public class MockAndStub {

    @Mock
    private UserRepository userRepository;

    /**
     * 특정 인자만 공급하는 경우 런타임 시 NPE가 발생하게 된다.
     */
    @Mock
    private FriendRepository friendRepository;

    @InjectMocks
    private UserService userService;

    private User getUser() {
        return new User("JayIsKind", "SanTeacherSoSmart", "Miller VS Adder Sleeping Battle");
    }


    @Test
    @DisplayName("목은 역할1")
    void 목_V1() throws Exception {
        userService = new UserService(userRepository, friendRepository);
    }

    @Test
    @DisplayName("목의 역할2")
    void 목_V2() throws Exception {
        userService = new UserService(userRepository, friendRepository);
        User user = getUser();

        Mockito.when(userRepository.join(user)).then(invocation -> {
            System.out.println("Mock Repository 사용");
            return user;
        });

        userService.join(user);

        // System.out.println(userRepository.findAll().size());

        Mockito.verify(userRepository, Mockito.times(1)).join(any());
        assertThat(userRepository.join(user).getId()).isEqualTo(user.getId());
        Mockito.verify(userRepository, Mockito.times(2)).join(any());
    }
}
