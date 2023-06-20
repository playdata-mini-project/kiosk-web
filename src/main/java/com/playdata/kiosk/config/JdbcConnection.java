package com.playdata.kiosk.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
    private final String URL = "jdbc:mysql://localhost:3306/kiosk" +
            "?serverTimezone=Asia/Seoul&characterEncoding=UTF-8";
    private final String USERNAME = "root";
    private final String PASSWORD = "admin";

    public Connection getJdbc()  {
        Connection conn;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager
                    .getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
}
