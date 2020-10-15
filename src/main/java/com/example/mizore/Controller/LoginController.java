package com.example.mizore.Controller;

import com.example.mizore.Bean.Admin;
import com.example.mizore.Bean.User;
import com.example.mizore.Service.AdminService;
import com.example.mizore.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;


@Controller
public class LoginController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;


    @RequestMapping(value={"/","/login"})
    public String init(){
       // System.out.println(-1);
        return "login";
    }
    @RequestMapping("/logincheck")
    public String logincheck(Model model, HttpSession session, User user,HttpServletRequest request){
        //System.out.println(-1);
        if(userService.login(user)){
            user=userService.getuser(user.getName());
            session.setAttribute("user",user);
            return "forward:/basic?ceta=0&pn=1";
        }
            else {
                request.setAttribute("failed",1);
                return "login";
        }
    }
    @RequestMapping("/register")
    public String register(){
        return "register1";
    }

    @RequestMapping("/registercheck")
    public String registercheck(User user, HttpSession session, HttpServletRequest request){
        System.out.println(-2);
       // System.out.println(user);
        if(userService.insert(user)==1){
          //  System.out.println(-3);
            request.setAttribute("isRegister",1);
            return "login";
        }
        else {
            request.setAttribute("error",1);
            return "register1";
        }
    }
}
