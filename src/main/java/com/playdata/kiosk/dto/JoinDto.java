package com.playdata.kiosk.dto;

import com.playdata.kiosk.domain.Role;

public class JoinDto {

    private String name;
    private String password;
    private String email;
    private Role role = Role.CUSTOMER;

    public JoinDto(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }
}
