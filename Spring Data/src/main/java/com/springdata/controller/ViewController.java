package com.springdata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;


@Controller
public class ViewController {

    //TODO Implement some gui
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showHome() {
        return "home";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAdd() {
        return "add";
    }

    @RequestMapping(value = "/bookAddSuccess")
    public String showBookSuccess(@RequestParam("title") String title,
                                  @RequestParam("author") String author,
                                  @RequestParam("isbn") String isbn,
                                  @RequestParam("category") String category) throws IOException {

        //TODO implement call to its own REST SERVICE
        System.out.println(title + author + isbn + category);

        return "bookAddSuccess";
    }
}
