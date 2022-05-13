package com.example.demo.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Optional;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsert;

    public UserRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource);

        simpleJdbcInsert.withTableName("users")
                .usingGeneratedKeyColumns("id");
    }

    public User insert(User user) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

//        jdbcTemplate.update(new PreparedStatementCreator() {
//            @Override
//            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//                PreparedStatement pstmt = con.prepareStatement("INSERT INTO users (name) VALUES (?)");
//                pstmt.setString(1, user.getName());
//                return pstmt;
//            }
//        }, keyHolder);
//
//        if (keyHolder.getKey() != null) {
//            user.setId(keyHolder.getKey().longValue());
//        }

        namedParameterJdbcTemplate.update("INSERT INTO users (name) VALUES (:name)"
                , new BeanPropertySqlParameterSource(user)
                , keyHolder);

        if (keyHolder.getKey() != null) {
            user.setId(keyHolder.getKey().longValue());
        }

        return user;
    }

    public User simpleInsert(User user) {
        Number generatedKey = simpleJdbcInsert.executeAndReturnKey(new BeanPropertySqlParameterSource(user));

        user.setId(generatedKey.longValue());
        
        return user;
    }

    public Optional<User> findById(Long id) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject("SELECT id, name FROM users WHERE id = :id", User.class, id));
        } catch (Exception e) {
            return Optional.empty();
        }

    }

    public void deleteAll() {
        jdbcTemplate.update("DELETE FROM users");
    }

}
