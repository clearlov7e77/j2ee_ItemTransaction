package com.example.nozomi.Controller;

import com.example.nozomi.Bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;
import java.util.Vector;

@Controller
public class JspController {
    private String hello="hello world";
    @RequestMapping(value={"/","/index"})
    public String index(Model model, HttpServletRequest request){
        User user=new User("xiaoran","123456");
    //    model.put("time",new Date());
    //    model.put("message",this.hello);
        Vector<Integer> v1=new Vector<Integer>(10);
        v1.add(3);
        v1.add(4);
        request.setAttribute("v1",v1);
        model.addAttribute(user);
        return "index";
    }
    @RequestMapping("/page1")
    public ModelAndView page1(){
        ModelAndView mav=new ModelAndView("page1");
        mav.addObject("content",hello);
        return mav;
    }
}
