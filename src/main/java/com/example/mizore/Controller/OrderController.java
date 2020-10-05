package com.example.mizore.Controller;

import com.example.mizore.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {

    @RequestMapping("/myorder")
    public String myoder(Model model){

        return "myorder";
    }
}
