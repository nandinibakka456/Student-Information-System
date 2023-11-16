package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {
    private Connection connection;

    private final String url = "jdbc:mysql://localhost:3306/Student_info"; 
    private final String username = "root";
    private final String password = "root"; 

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
               
                Class.forName("com.mysql.cj.jdbc.Driver"); 
                connection = DriverManager.getConnection(url, username, password);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
