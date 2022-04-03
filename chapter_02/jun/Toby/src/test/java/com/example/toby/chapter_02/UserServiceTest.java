package com.example.toby.chapter_02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class UserSeopenrviceTest {

    @Spy
    private UserRepository userRepository;

    @Mock
    private FriendRepository friendRepository;

    @InjectMocks
    private UserService userService;

    private User getUser() {
        return new User("JayIsKind", "SanTeacherSoSmart", "Miller VS Adder Sleeping Battle");
    }

    private Friend getFriend() {
        return new Friend("JayIsKind", "SanTeacherSoSmart", "Miller VS Adder Sleeping Battle");
    }

    @Test
    @DisplayName("목객체를 등록하고 사용하면 실제 객체가 아닌 해당 목 객체가 사용 된다.")
    void 목_객체의_중_특정_인자만_공급() {
        User user = getUser();

        Mockito.when(userRepository.join(user)).then(invocation -> {
            System.out.println("Mock Repository 사용");
            return user;
        });

        userService.join(user);

//        System.out.println(userRepository.findAll().size());

        Mockito.verify(userRepository, Mockito.times(1)).join(any());
        assertThat(userRepository.join(user).getId()).isEqualTo(user.getId());
        Mockito.verify(userRepository, Mockito.times(2)).join(any());
    }

    @Test
    @DisplayName("목객체를 사용하지않으면 런타임에 NullPointException이 발생한다.")
    void 특정인자만_공급시_런타임에_에러가_발생한다() {
        Friend friend = getFriend();

        Mockito.when(friendRepository.join(friend)).then(invocation -> {
            System.out.println("Mock Repository 사용");
            return friend;
        });
        friendRepository.join(friend);
    }


    @Test
    @DisplayName("스텁을 끼우고 아무것도 하지 않으면 오류가 발생한다.")
    void 스텁과_상호작용() {
        User user = getUser();

        Mockito.when(userRepository.join(user)).then(invocation -> {
            System.out.println("Mock Repository 사용");
            return user;
        });

        userService.join(user);

        // Mockito.verify(userRepository, Mockito.times(1)).join(any());
        assertThat(userRepository.join(user).getId()).isEqualTo(user.getId());
    }

    /**
     *
     */
    @Test
    @DisplayName("SPY를 사용시 해당 메서드만 목이고 나머진 진짜 객체를 사용한다.")
    void SPY객체_사용() {
        User user = getUser();

        Mockito.doAnswer(invocation -> {
            System.out.println("Spy Repository 사용");
            return null;
        }).when(userRepository).join(user);

        userService.join(user);
        userRepository.findAllVoid();

        Mockito.verify(userRepository, Mockito.times(1)).findAllVoid();
        assertThat(userRepository.findAll().size()).isEqualTo(0);
    }
}
