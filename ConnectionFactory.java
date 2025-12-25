package com.codegnan.factory;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Factory class — provides database connection
// to DAO classes using JDBC

public class ConnectionFactory {

    private static final String URL = "jdbc:mysql://localhost:3306/jfs44";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Harshi@Ps18";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
