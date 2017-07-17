package com.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    //controller will return view name (also will add prefix and suffix)
    @RequestMapping("/")
    public String showMyPage(){
        return "main";
    }

}
