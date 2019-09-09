package org.propertea.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model m) {
        m.addAttribute("someAttribute", "someValue");
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String index() {
        return "redirect:/login";
    }
}
