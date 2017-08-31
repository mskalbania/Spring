package com.springsecurity.controller;

import com.springsecurity.config.UserResponse;
import com.springsecurity.dto.User;
import com.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerSuccessPage(@ModelAttribute User user, Model model) {
        UserResponse userResponse = userService.create(user);
        model.addAttribute("response", userResponse);
        return "registerProcess";
    }

    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public String userList(Model model) {
        updateList(model);
        return "userList";
    }

    @RequestMapping(value = "/disable/{username}", method = RequestMethod.GET)
    public String disable(@PathVariable String username, Model model) {
        userService.disable(username);
        updateList(model);
        return "userList";
    }

    @RequestMapping(value = "/enable/{username}", method = RequestMethod.GET)
    public String enable(@PathVariable String username, Model model) {
        userService.enable(username);
        updateList(model);
        return "userList";
    }

    @RequestMapping(value = "/change", method = RequestMethod.POST)
    public String change(@ModelAttribute User user, Model model) {
        userService.updateRole(user);
        updateList(model);
        return "userList";
    }

    private void updateList(Model model) {
        List<User> userList = userService.getAll();
        model.addAttribute("userList", userList);
    }
}
