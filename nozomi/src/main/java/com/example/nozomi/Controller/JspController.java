package com.example.nozomi.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Map;
@Controller
public class JspController {
    private String hello="hello world";
    @RequestMapping(value={"/","/index"})
    public String index(Map<String,Object> model){
        model.put("time",new Date());
        model.put("message",this.hello);
        return "index";
    }
    @RequestMapping("/page1")
    public ModelAndView page1(){
        ModelAndView mav=new ModelAndView("page1");
        mav.addObject("content",hello);
        return mav;
    }
}
