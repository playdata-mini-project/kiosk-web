package com.playdata.kiosk.dao;

import com.playdata.kiosk.config.JdbcConnection;
import com.playdata.kiosk.dto.OrderHistoryDto;
import com.playdata.kiosk.dto.ProductDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderHistoryDao {
    public List<OrderHistoryDto> findAll() {
        List<OrderHistoryDto> orderHistoryDtos = new ArrayList<OrderHistoryDto>();
        Connection conn = new JdbcConnection().getJdbc();
        String sql = "select u.NAME, c.NAME, p.NAME, od.AMOUNT, p.PRICE, o.ORDERED_AT\n" +
                "from USERS u, ORDER_HISTORY o, ORDER_HISTORY_DETAIL od, PRODUCT p, CATEGORY c\n" +
                "where u.ID = o.USER_ID and o.ID = od.ORDER_HISTORY_ID and od.PRODUCT_ID = p.ID\n" +
                "and p.CATEGORY_ID = c.ID;";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                orderHistoryDtos.add(
                        new OrderHistoryDto(resultSet.getString("uname"),
                                resultSet.getString("cname"),
                                resultSet.getString("pname"),
                                resultSet.getInt("amount"),
                                resultSet.getInt("price"),
                                resultSet.getDate("orderdeAt")
                                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderHistoryDtos;
    }
}
