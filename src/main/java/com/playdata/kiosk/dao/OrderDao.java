package com.playdata.kiosk.dao;

import com.playdata.kiosk.config.JdbcConnection;

import java.sql.*;

public class OrderDao {
    Connection conn = new JdbcConnection().getJdbc();
    PreparedStatement pst;
    ResultSet rs;

    public void order(Long productId, int quantity) {

        String sql = "update product set quantity = quantity - ? " +
                     "where id = ? ";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, quantity);
            pst.setLong(2, productId);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int orderSave(Long userId) {
        int orderHistoryId = 0;

        String sql = "insert into order_history(user_id) " +
                     "values (?) ";
        try {
            pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setLong(1, userId);
            pst.executeUpdate();
            ResultSet generatedKeys = pst.getGeneratedKeys();

            if (generatedKeys.next()) {
                orderHistoryId = generatedKeys.getInt(1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  orderHistoryId;
    }

    public void orderDetailSave(int orderHistoryId, Long productId, int quantity) {

        String sql = "insert into order_history_detail (order_history_id,product_id,amount) " +
                     "values (?,?,?) ";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, orderHistoryId);
            pst.setLong(2, productId);
            pst.setInt(3, quantity);
            pst.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
