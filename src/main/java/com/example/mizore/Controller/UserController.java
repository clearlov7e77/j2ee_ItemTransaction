package com.example.mizore.Controller;

import com.example.mizore.Bean.Good;
import com.example.mizore.Bean.Order;
import com.example.mizore.Bean.User;
import com.example.mizore.Service.GoodService;
import com.example.mizore.Service.OrderService;
import com.example.mizore.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    OrderService orderService;

    @Autowired
    UserService userService;

    @Autowired
    GoodService goodService;

    @RequestMapping("/personal")
    public String personal(String tab, HttpServletRequest request, HttpSession session){
        request.setAttribute("tab",tab);
        if(tab==null);
        else if(tab.equals("push"));
        else if(tab.equals("myorder")){
            User user=(User) session.getAttribute("user");
            List<Order> list=orderService.getmyorder(user.getName());
            request.setAttribute("list",list);
        }
        else if(tab.equals("info")){
            if(request.getParameter("sign")!=null) {
                String address = request.getParameter("address");
            //    String sign = request.getParameter("sign");
            //    System.out.println(sign);
                User user = (User) session.getAttribute("user");
                if (address != user.getAddress()) request.setAttribute("success", 1);
                userService.updateaddress(user.getId(), address);
                user = userService.getuser(user.getName());
                session.setAttribute("user", user);
            }
           //     System.out.println(address);
        }
        else if(tab.equals("pushed")){
                User user=(User) session.getAttribute("user");
                List<Good> list= goodService.getgoodbyseller(user.getName());
                request.setAttribute("list",list);
        }
        return "personal";
    }
}
