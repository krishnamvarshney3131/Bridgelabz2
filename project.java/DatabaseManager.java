package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    // ---- DATABASE CONFIGURATION ----
    private static final String URL = "jdbc:mysql://localhost:3306/student_db";
    private static final String USER = "root";     // your MySQL username
    private static final String PASSWORD = "Jatin98@";     // your MySQL password

    // ---- GET CONNECTION METHOD ----
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("❌ Failed to connect to database!");
            e.printStackTrace();
            return null;
        }
    }
}
