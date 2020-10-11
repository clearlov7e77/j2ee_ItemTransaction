package com.example.mizore.Controller;

import com.example.mizore.Bean.Good;
import com.example.mizore.Bean.Order;
import com.example.mizore.Bean.User;
import com.example.mizore.Service.GoodService;
import com.example.mizore.Service.OrderService;
import com.example.mizore.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.*;

@Controller
public class GoodController {
    @Autowired
    GoodService goodService;

    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @RequestMapping("/newproduct")
    public String newproduct(Good good, HttpServletRequest request,HttpSession session){
        User user=(User)session.getAttribute("user");
        good.setSeller(user.getName());
        if(goodService.insertGood(good)==1){
            request.setAttribute("success",1);
        }
        else{
            request.setAttribute("error",1);
        }
        request.setAttribute("tab","push");
        return "personal";
    }
    @RequestMapping("/basic")

    public String basic(int ceta, HttpServletRequest request, int pn, HttpSession session, Model model){
      //  System.out.println(ceta);
        String info=(String)request.getParameter("info");
    //    System.out.println(info);
        request.setAttribute("info",info);
        request.setAttribute("ceta", ceta);
        if(ceta==7){
            String key=request.getParameter("key");
        //    System.out.println(key);
            List<Good> list = goodService.getgoodbyname(key);
            int size1 = list.size();
            int perpage = 7;
            int maxpage = (size1 + perpage - 1) / perpage;
            request.setAttribute("pn", pn);
            request.setAttribute("maxpage", maxpage);
            List<Good> list1 = new ArrayList<>();
            for (int i = (pn - 1) * 7; i <= (pn - 1) * 7 + 6; i++) {
                if (i < size1) list1.add(list.get(i));
            }
            request.setAttribute("list", list1);
        }
        else {
            if (ceta == 0) {
                List<Good> list = goodService.getallgood();
                int size1 = list.size();
                int perpage = 7;
                int maxpage = (size1 + perpage - 1) / perpage;
                request.setAttribute("pn", pn);
                request.setAttribute("maxpage", maxpage);
                List<Good> list1 = new ArrayList<>();
                for (int i = (pn - 1) * 7; i <= (pn - 1) * 7 + 6; i++) {
                    if (i < size1) list1.add(list.get(i));
                }
                request.setAttribute("list", list1);
                // request.setAttribute("list",list);
            } else {
                String[] temp = {" ", "book", "live", "clothes", "electronic", "sport", "other"};
                List<Good> list = goodService.getgoodbytype(temp[ceta]);
                int size1 = list.size();
                int perpage = 7;
                int maxpage = (size1 + perpage - 1) / perpage;
                request.setAttribute("pn", pn);
                request.setAttribute("maxpage", maxpage);
                List<Good> list1 = new ArrayList<>();
                for (int i = (pn - 1) * 7; i <= (pn - 1) * 7 + 6; i++) {
                    if (i < size1) list1.add(list.get(i));
                }
                request.setAttribute("list", list1);
                //   request.setAttribute("list",list);
            }
        }
        return "basic";
    }
    @RequestMapping("/good")
    public String good(int goodid, HttpServletRequest request, Model model){
        Good good=goodService.findGood(goodid);
        model.addAttribute(good);
        return "good";
    }
    @RequestMapping("/buy")
    public String buy(int goodid,int userid,Model model,HttpSession session,HttpServletRequest request){
        Good good=goodService.findGood(goodid);
        User user=userService.getuserbyid(userid);
        int price=goodService.findGood(goodid).getPrice();
        int money=userService.getuserbyid(userid).getMoney();
        String info;
        if(money<price){
            info="failed";
        }
        else {
            goodService.updatecount(goodid);
            userService.updatemoney(userid, money-price);
            User seller=userService.getuser(good.getSeller());
            userService.updatemoney(seller.getId(),seller.getMoney()+price);
            Order order=new Order(1,good.getName(),price,user.getAddress(),user.getName(),good.getSeller());
            orderService.insertorder(order);
            session.setAttribute("user",userService.getuserbyid(userid));
            info="success";
        }
      //  request.setAttribute("info",info);
     //   System.out.println(info);
        return "redirect:/basic?ceta=0&pn=1&info="+info;
    }
}
