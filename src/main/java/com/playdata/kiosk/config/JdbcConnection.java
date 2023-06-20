package com.playdata.kiosk.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
    private final String url = "jdbc:mysql://localhost:3306/kiosk" +
            "?serverTimezone=Asia/Seoul&characterEncoding=UTF-8";
    private final String username = "root";
    private final String password = "1q2w3e4r!!";

    public Connection getJdbc()  {
        Connection conn;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager
                    .getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
}