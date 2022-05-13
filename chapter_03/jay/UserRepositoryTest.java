package com.example.demo.jdbctemplate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.test.context.jdbc.Sql;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
@Sql("classpath:sql/ddl-user.sql")
class UserRepositoryTest {

    @Autowired
    private DataSource dataSource;

    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepository(dataSource);
        userRepository.deleteAll();
    }

    @Test
    void insert_테스트1() {
        // given
        Long expectedId = 1L;
        String expectedName = "jay";

        // when
        User savedUser = userRepository.insert(new User(expectedName));

        // then
        assertThat(savedUser.getId()).isEqualTo(expectedId);
        assertThat(savedUser.getName()).isEqualTo(expectedName);
    }

    @Test
    void simpleJdbcInsert_테스트1() {
        // given
        Long expectedId = 1L;
        String expectedName = "jay";

        // when
        User savedUser = userRepository.simpleInsert(new User(expectedName));

        // then
        assertThat(savedUser.getId()).isEqualTo(expectedId);
        assertThat(savedUser.getName()).isEqualTo(expectedName);
    }

    @Test
    void simpleJdbcInsert_테스트2() {
        // given
        Long expectedId = 1L;
        String expectedName = "jay";

        // when
        User savedUser = userRepository.simpleInsert(new User(expectedName));

        // then
        assertThat(savedUser.getId()).isEqualTo(expectedId);
        assertThat(savedUser.getName()).isEqualTo(expectedName);
    }
}