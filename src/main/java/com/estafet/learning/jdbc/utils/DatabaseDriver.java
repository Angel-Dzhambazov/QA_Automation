package com.estafet.learning.jdbc.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DatabaseDriver implements DatabaseHelper {


    protected Connection setConnection(String jdbcURL, String username, String password) {
        try {
            return DriverManager.getConnection(jdbcURL, username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
