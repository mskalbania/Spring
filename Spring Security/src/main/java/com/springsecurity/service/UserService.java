package com.springsecurity.service;

import com.springsecurity.config.UserResponse;
import com.springsecurity.dao.UserDao;
import com.springsecurity.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
public class UserService {

    private UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserResponse create(User user) {
        if (!Objects.equals(user.getPassword(), user.getRepeatedPassword())) {
            return new UserResponse("Password does not match");
        }
        boolean success = userDao.create(user);
        return success ? new UserResponse() : new UserResponse("User" + user.getUsername() + " already exist!");
    }

    public List<User> getAll() {
        return userDao.getAllUsers();
    }

    public void disable(String username) {
        userDao.disable(username);
    }

    public void enable(String username) {
        userDao.enable(username);
    }

    public void updateRole(User user) {
        userDao.updateRole(user);
    }

    public List<User> getByUsername(String username) {
        return userDao.getByUsername(username);
    }
}
