package com.tommenx.dao;

import com.tommenx.entity.User;

import java.util.List;

public interface UserDao {
    int add(User user);

    int del(User user);

    int update(User user);

    User findOneById(int Id);

    List<User> findAll();
}
