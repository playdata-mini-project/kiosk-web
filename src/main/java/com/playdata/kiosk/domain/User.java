package com.playdata.kiosk.domain;

public class User {

    private Long id;
    private String name;
    private String password;
    private Role role;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public static User createLoginUser(Long id, String name, Role role){
        User user = new User();
        user.id = id;
        user.name = name;
        user.role = role;
        return user;
    }
}
