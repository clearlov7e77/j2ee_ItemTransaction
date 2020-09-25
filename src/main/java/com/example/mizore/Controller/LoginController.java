package com.example.mizore.Controller;

import com.example.mizore.Bean.Admin;
import com.example.mizore.Bean.User;
import com.example.mizore.Service.AdminService;
import com.example.mizore.Service.CustomerService;
import com.example.mizore.Service.SellerService;
import com.example.mizore.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private AdminService adminService;
    private UserService userService;

    @RequestMapping("/")
    public String init(){
        return "login";
    }
    @RequestMapping("/login")
    public String login(Model model, HttpSession session, User user){
        if(userService.login(user))return ''
        else{
            Admin admin=new Admin(user.getName(),user.getPassword());
            if(adminService.adminlogin(admin))return "admin";
            else return "falied"
        }
    }
    @RequestMapping("/register")
    public String register(){

    }
    @RequestMapping("/")
}
