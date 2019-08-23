package com.jef.propertea;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("")
@Controller
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public String printHello(ModelMap model){
        //"message" is an attribute in "hello.jsp", "hello.jsp" is created by yourself
        model.addAttribute("message", "Hello Spring MVC Framework!");
        //transform "hello" to "hello.jsp"
        return "hello";
    }
}
