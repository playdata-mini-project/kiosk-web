package com.playdata.kiosk.dao;

import com.playdata.kiosk.dto.ProductDetailDto;
import com.playdata.kiosk.dto.ProductDto;
import com.playdata.kiosk.config.JdbcConnection;
import com.playdata.kiosk.dto.ProductListDto;
import com.playdata.kiosk.servlet.ProductUpdateServlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    public void insert(ProductDto product) {
        Connection conn = new  JdbcConnection().getJdbc();
        String sql = "insert into product(name, category_id, quantity, price, make_time, img_url) " +
                "values(?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, product.getName());
            pst.setInt(2, product.getCategoryId());
            pst.setInt(3, product.getQuantity());
            pst.setInt(4, product.getPrice());
            pst.setInt(5, product.getMakeTime());
            pst.setString(6, product.getImgUrl());
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

    public List<ProductListDto> productList(int category) {

        Connection conn = new  JdbcConnection().getJdbc();
        ArrayList<ProductListDto> productList = new ArrayList<>();

        String sql = "select id,name,price,img_url,quantity from product " +
                "where category_id = ? or 0 = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst = conn.prepareStatement(sql);

            pst.setInt(1, category);
            pst.setInt(2, category);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ProductListDto product = new ProductListDto(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5)
                );
                productList.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return productList;
    }

    public ProductDetailDto productDetail(Long id) {
        Connection conn = new  JdbcConnection().getJdbc();
        String sql = "select id,name,price,img_url,quantity from product " +
                "where id = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst = conn.prepareStatement(sql);

            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();

            ProductDetailDto product = new ProductDetailDto();
            while (rs.next()) {
                product = new ProductDetailDto(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5)
                );
            }
            return product;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateProductQuantity(ProductDto productDto) {
        Connection conn = new  JdbcConnection().getJdbc();
        String sql = "update product " +
                        "set quantity = ? " +
                        "where id = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, productDto.getQuantity() + productDto.getAddQuantity());
            pst.setInt(2, productDto.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

