package com.playdata.kiosk.utility;


import com.playdata.kiosk.config.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InitDb {

    List<String> queryList = new ArrayList<>();
    public void initDb(){

        setDatabase();
        createTables();
        insertData();

        Connection conn = new JdbcConnection().getJdbc();

        for (String query : queryList) {
            try {
                PreparedStatement psmt = conn.prepareStatement(query);
                psmt.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    private void setDatabase(){

        queryList.add(DROP_DATABASE);
        queryList.add(CREATE_DATABASE);
        queryList.add(USE_DATABASE);
    }
    private void createTables(){

        queryList.add(CREATE_CATEGORY_TABLE);
        queryList.add(CREATE_PRODUCT_TABLE);
        queryList.add(CREATE_USERS_TABLE);
        queryList.add(CREATE_ORDER_HISTORY_TABLE);
        queryList.add(CREATE_ORDER_HISTORY_DETAIL_TABLE);
    }
    public void insertData(){

        queryList.add(createUsersQuery("red", "1111", "red@admin.com", "ADMIN"));
        queryList.add(createUsersQuery("blue", "2222", "blue@customer.com", "CUSTOMER"));

        queryList.add(createCategoryQuery("커피"));
        queryList.add(createCategoryQuery("티"));
        queryList.add(createCategoryQuery("스무디"));


        queryList.add(createProductQuery("아메리카노", 20, 1, 1500, 100, "https://www.mmthcoffee.com/files/menu/abb8d3886846e2ac168f8433390f1a8b.png"));
        queryList.add(createProductQuery("꿀라떼", 30, 1, 2000, 100, "https://www.mmthcoffee.com/files/menu/5c3aa520d5611683eda068700afc4b94.png"));
        queryList.add(createProductQuery("밀크티", 20, 2, 3000, 100, "https://www.mmthcoffee.com/files/menu/d101c2f9a1589fd4f228c689d37f94a0.png"));
        queryList.add(createProductQuery("캐모마일티", 30, 2, 3500, 100, "https://www.mmthcoffee.com/files/menu/5db721802768bfa14fc4ef7c590c91fc.png"));
        queryList.add(createProductQuery("딸기 요거트 스무디", 80, 3, 4500, 100, "https://www.mmthcoffee.com/files/menu/d2d25ee1074aced4b5b3be0b4e851d25.png"));
        queryList.add(createProductQuery("블루베리 요거트 스무디", 60, 3, 5500, 100, "https://www.mmthcoffee.com/files/menu/3a3e0405ca37731e94f9e90423784df3.png"));
    }
    private final String DROP_DATABASE = "DROP DATABASE KIOSK";
    private final String CREATE_DATABASE = "CREATE DATABASE KIOSK";
    private final String USE_DATABASE = "USE KIOSK";

    private String createCategoryQuery(String categoryName) {
        return "INSERT INTO CATEGORY(NAME) " +
                "VALUES ('" + categoryName + "')";
    }
    private String createUsersQuery(String name, String password, String email, String role) {
        return "INSERT INTO USERS(NAME, PASSWORD, MAIL, ROLE) " +
                "VALUES ('" + name + "', '" + password + "', '" + email + "', '" + role + "')";
    }
    private String createProductQuery(String name, int makeTime, int categoryId, int price, int quantity, String imgUrl) {
        return "INSERT INTO PRODUCT(NAME, MAKE_TIME, CATEGORY_ID, PRICE, QUANTITY, IMG_URL) " +
                "VALUES ('" + name + "', " + makeTime + ", " + categoryId + ", " + price + ", " + quantity + ", '" + imgUrl + "')";
    }
    private final String CREATE_CATEGORY_TABLE =
            "CREATE TABLE CATEGORY" +
                    "(ID INT AUTO_INCREMENT PRIMARY KEY," +
                    "NAME VARCHAR(255) NOT NULL)";
    private final String CREATE_PRODUCT_TABLE =
            "CREATE TABLE PRODUCT" +
                    "(ID INT AUTO_INCREMENT PRIMARY KEY," +
                    "NAME VARCHAR(255) NOT NULL," +
                    "MAKE_TIME INT," +
                    "CATEGORY_ID INT," +
                    "PRICE INT," +
                    "QUANTITY INT," +
                    "IMG_URL VARCHAR(255)," +
                    "FOREIGN KEY (CATEGORY_ID) REFERENCES CATEGORY(ID))";
    private final String CREATE_USERS_TABLE =
            "CREATE TABLE USERS" +
                    "(ID INT AUTO_INCREMENT PRIMARY KEY," +
                    "NAME VARCHAR(255) NOT NULL," +
                    "PASSWORD VARCHAR(255) UNIQUE KEY NOT NULL," +
                    "MAIL VARCHAR(255)," +
                    "ROLE VARCHAR(255)," +
                    "JOINED_AT DATETIME DEFAULT NOW())";
    private final String CREATE_ORDER_HISTORY_TABLE =
            "CREATE TABLE ORDER_HISTORY" +
                    "(ID INT AUTO_INCREMENT PRIMARY KEY," +
                    "USER_ID INT," +
                    "ORDERED_AT DATETIME DEFAULT NOW()," +
                    "FOREIGN KEY (USER_ID) REFERENCES USERS (ID))";
    private final String CREATE_ORDER_HISTORY_DETAIL_TABLE =
            "CREATE TABLE ORDER_HISTORY_DETAIL(" +
                    "ID INT AUTO_INCREMENT PRIMARY KEY," +
                    "ORDER_HISTORY_ID INT," +
                    "PRODUCT_ID INT," +
                    "AMOUNT INT," +
                    "FOREIGN KEY (ORDER_HISTORY_ID) REFERENCES ORDER_HISTORY (ID)," +
                    "FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCT (ID))";
}
