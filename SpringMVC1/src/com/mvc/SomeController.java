package com.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/a")
public class SomeController {

    @RequestMapping("/a")
    public String aa(){
        return "helloworld";
    }


}
