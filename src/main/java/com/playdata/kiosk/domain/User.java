package com.playdata.kiosk.domain;

public class User {

    private Long id;
    private String name;
    private String password;
    private String role;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public static User createLoginUser(Long id, String name, String role){
        User user = new User();
        user.id = id;
        user.name = name;
        user.role = role;
        return user;
    }
}
