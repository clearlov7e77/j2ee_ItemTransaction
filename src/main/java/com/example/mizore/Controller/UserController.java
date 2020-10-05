package com.example.mizore.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @RequestMapping("/personal")
    public String personal(){
        return "personal";
    }
}
