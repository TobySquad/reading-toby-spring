package com.example.jun.connection;

import java.sql.SQLException;

public interface DataSource {
    Connection getConnection() throws SQLException;
}
