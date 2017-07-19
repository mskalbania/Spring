package com.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("/showStudentForm")
    public String showForm(Model model){
        model.addAttribute("student", new Student());
        return "form";
    }

    @RequestMapping("/processStudentForm")
    public String showProcessed(@ModelAttribute("student") Student student){
        return "confirmation";
    }
}
