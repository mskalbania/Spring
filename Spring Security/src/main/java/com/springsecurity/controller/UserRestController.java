package com.springsecurity.controller;

import com.springsecurity.dto.User;
import com.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/getByName/{username}")
    public List<User> getByUsername(@PathVariable("username") String username) {
        return userService.getByUsername(username);
    }

    @RequestMapping(value = "/getByName")
    public List<User> getAll(){
        return userService.getAll();
    }
}
