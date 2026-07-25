package com.bank.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static Connection con;

    public static Connection getConnection() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/onlinebanking",
                    "root",
                    "Babu@2026"
            );

        } catch(Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}