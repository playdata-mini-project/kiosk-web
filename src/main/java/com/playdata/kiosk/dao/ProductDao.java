package com.playdata.kiosk.dao;

import com.playdata.kiosk.dto.ProductDto;
import com.playdata.kiosk.config.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    public void insert(ProductDto product) {
        Connection conn = new  JdbcConnection().getJdbc();
        String sql = "insert into product(name, category_id, quantity, price, make_time) " +
                "values(?, ?, ?, ?, ?)";

        System.out.println(product.getName());
        System.out.println(product.getCategoryId());
        System.out.println(product.getQuantity());
        System.out.println(product.getPrice());
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
//            pst.setInt(1, product.getId());
            pst.setString(1, product.getName());
            pst.setInt(2, product.getCategoryId());
            pst.setInt(3, product.getQuantity());
            pst.setInt(4, product.getPrice());
            pst.setInt(5, product.getMakeTime());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ProductDto> findAll() {
        List<ProductDto> productDtos = new ArrayList<ProductDto>();
        Connection conn = new JdbcConnection().getJdbc();
        String sql = "select id, name, category_id, quantity, price, make_time\n" +
                " from product;";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                productDtos.add(
                        new ProductDto(resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getInt("category_id"),
                                resultSet.getInt("quantity"),
                                resultSet.getInt("price"),
                                resultSet.getInt("make_time"))
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productDtos;
    }

}

