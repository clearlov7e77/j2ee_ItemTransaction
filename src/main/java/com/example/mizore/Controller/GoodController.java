package com.example.mizore.Controller;

import com.example.mizore.Bean.Good;
import com.example.mizore.Service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("/newproduct")
    public String newproduct(Good good, HttpServletRequest request){
        if(goodService.insertGood(good)==1){
            request.setAttribute("success",1);
        }
        else{
            request.setAttribute("error",1);
        }
        return "push";
    }
    @RequestMapping("/basic")

    public String basic(int ceta, HttpServletRequest request, int pn, HttpSession session){
      //  System.out.println(ceta);
        if(ceta==7){
            String key=request.getParameter("key");
            System.out.println(key);
            
        }
        else {
            request.setAttribute("ceta", ceta);
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
}
