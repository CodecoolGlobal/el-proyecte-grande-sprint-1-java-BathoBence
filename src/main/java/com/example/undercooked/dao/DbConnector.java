package com.example.undercooked.dao;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DbConnector {

    private final String DB_URL = System.getenv("DB_URL");
    private final String DB_USERNAME = System.getenv("DB_USERNAME");
    private final String DB_PASSWORD = System.getenv("DB_PASSWORD");

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(this.DB_URL, this.DB_USERNAME, this.DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println("Could not connect to database");
            throw new RuntimeException(e);
        }
    }
}

