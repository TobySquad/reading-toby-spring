package com.example.jun.connection;

import org.springframework.jdbc.CannotGetJdbcConnectionException;

import java.sql.SQLException;

public abstract class DataSourceUtils {
    public static Connection getConnection(DataSource dataSource) throws CannotGetJdbcConnectionException {
        try {
            return doGetConnection(dataSource);
        } catch (SQLException ex) {
            throw new CannotGetJdbcConnectionException("Failed to obtain JDBC Connection", ex);
        } catch (IllegalStateException ex) {
            throw new CannotGetJdbcConnectionException("Failed to obtain JDBC Connection: " + ex.getMessage());
        }
    }

    public static Connection doGetConnection(DataSource dataSource) throws SQLException {
        return dataSource.getConnection();
    }
}
