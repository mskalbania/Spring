package com.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletRequest;

@Controller
@RequestMapping("/")
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

    @RequestMapping("/digit-input")
    public String digitInput(){
        return"digit-input";
    }

    @RequestMapping("/digit-output")
    public String digitOutput(@RequestParam("digit") int digit, Model model){
        model.addAttribute("dec",Integer.toString(digit));
        model.addAttribute("bin",Integer.toBinaryString(digit));
        model.addAttribute("hex",Integer.toHexString(digit));
        model.addAttribute("oct",Integer.toOctalString(digit));
        return "digit-output";
    }
}
