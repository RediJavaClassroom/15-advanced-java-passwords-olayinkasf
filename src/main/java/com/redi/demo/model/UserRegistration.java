package com.redi.demo.model;


public class UserRegistration {
    public final String email;
    public final String password;
    public final String name;

    public UserRegistration(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }
}
