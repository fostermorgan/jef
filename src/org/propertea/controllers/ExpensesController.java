package org.propertea.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/expenses")
public class ExpensesController {

    @RequestMapping(method = RequestMethod.GET)
    public String expenseGet(Model m) {
        return "expenses";
    }
}
