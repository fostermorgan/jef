package org.propertea.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    @RequestMapping(method = RequestMethod.GET)
    public String dashboardGet(Model m) {
        return "dashboard";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String dashboardPost(Model m) {
        m.addAttribute("someAttribute", "someValue");
        return "dashboard";
    }
}
