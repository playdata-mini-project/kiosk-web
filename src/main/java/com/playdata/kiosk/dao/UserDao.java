package com.playdata.kiosk.dao;

import com.playdata.kiosk.config.JdbcConnection;
import com.playdata.kiosk.domain.Role;
import com.playdata.kiosk.domain.User;
import com.playdata.kiosk.dto.JoinDto;
import com.playdata.kiosk.dto.LoginDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public void join(JoinDto dto) {
        Connection conn = new JdbcConnection().getJdbc();

        String sql = "insert into users(name, password, email, role) " +
                "values(?, ?, ?, ?)";

        try{
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, dto.getName());
            pst.setString(2, dto.getPassword());
            pst.setString(3, dto.getEmail());
            pst.setString(4, dto.getRole().toString());

            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User login(LoginDto dto){
        Connection conn = new JdbcConnection().getJdbc();

        String sql = "select id, name, email, role " +
                "from users " +
                "where name = ? and password = ?";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, dto.getName());
            pst.setString(2, dto.getPassword());

            ResultSet resultSet = pst.executeQuery();

            if(resultSet.next()){
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String role = resultSet.getString("role");
                return User.createLoginUser(id, name, email, Role.valueOf(role));
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
