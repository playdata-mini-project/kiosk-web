package com.playdata.kiosk.domain;

public class User {

    private Long id;
    private String name;
    private String password;
    private String mail;
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
    public String getMail() {
        return mail;
    }

    public Role getRole() {
        return role;
    }

    public static User createLoginUser(Long id, String name, String email, Role role){
        User user = new User();
        user.id = id;
        user.name = name;
        user.mail = email;
        user.role = role;
        return user;
    }
}
