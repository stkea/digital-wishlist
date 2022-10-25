package com.example.wishlistproject.Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Class is implemented as a singleton to ensure that only
// one database connection is active at a time.
public class DatabaseService {
    private static DatabaseService instance;
    private Connection connection;

    private DatabaseService() {
        Connection conn = establishDBConnection();
        connection = conn;
    }

    public static DatabaseService getInstance() {
        if (instance == null) {
            instance = new DatabaseService();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    private Connection establishDBConnection() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wishlist");
            return conn;
        } catch (SQLException e) {
            System.out.println("Failed to establish a database connection");
        }
        return null;
    }
}
