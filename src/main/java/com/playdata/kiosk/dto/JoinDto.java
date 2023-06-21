package com.playdata.kiosk.dto;

import com.playdata.kiosk.domain.Role;

public class JoinDto {

    private String name;
    private String password;
    private String mail;
    private Role role = Role.CUSTOMER;

    public JoinDto(String name, String password, String mail) {
        this.name = name;
        this.password = password;
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getMail() {
        return mail;
    }

    public Role getRole() {
        return role;
    }
}
