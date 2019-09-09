package org.propertea.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/lists")
public class ListsController {

    @RequestMapping(method = RequestMethod.GET)
    public String listsGet(Model m) {
        return "lists";
    }
}
