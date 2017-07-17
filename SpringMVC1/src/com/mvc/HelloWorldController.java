package com.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletRequest;

@Controller
public class HelloWorldController {

    @RequestMapping("/")
    public String showMain(){
        return "main";
    }

    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm(ServletRequest request, Model model) {
        String name = request.getParameter("studentName");

        model.addAttribute("message", "YO " + name.toUpperCase() + "!!!");
        return "helloworld";
    }
}
