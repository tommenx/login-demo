package com.tommenx.entity;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String phone;
    private String username;
    private String password;


    public User() {
    }


    public User(int id, String phone, String username, String password) {
        this.id = id;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                "phone='" + phone + '\'' +
                "name='" + username + '\'' +
                ", pwd='" + password + '\'' +
                '}';
    }
}