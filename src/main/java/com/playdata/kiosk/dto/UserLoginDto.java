package com.playdata.kiosk.dto;

public class UserLoginDto {
    private String name;
    private String password;

    public UserLoginDto(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}


