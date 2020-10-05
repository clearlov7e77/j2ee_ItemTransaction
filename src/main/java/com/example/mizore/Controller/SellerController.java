package com.example.mizore.Controller;

import com.example.mizore.Bean.Good;
import com.example.mizore.Service.GoodService;
import com.example.mizore.Service.SellerService;
import com.example.mizore.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
public class SellerController {
    @Autowired
    UserService userService;

    @Autowired
    GoodService goodService;

    @Autowired
    SellerService sellerService;

    @RequestMapping("/push")
    public String push(){
        return "push";
    }

}
