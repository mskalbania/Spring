package com.springsecurity.dao;

import com.springsecurity.dto.User;

import java.util.List;

public interface UserDao {

    boolean create(User user);

    List<User> getAllUsers();

    void disable(String username);

    void enable(String username);

    void updateRole(User user);

    List<User> getByUsername(String username);
}
