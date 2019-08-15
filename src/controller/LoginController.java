package controller;

import database.finance.UserDAO;
import model.finance.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserDAO userDAO;

    public LoginController(UserDAO userDAO){
        this.userDAO = userDAO;
    }


    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView loginVerification(HttpServletRequest request){
        ModelAndView mav = new ModelAndView("login");
        //find user from given email on login and store it into toFind
        User toFind = userDAO.findUserByEmail(request.getParameter("email"));

        //if user doesn't exist display messsage and return to login page
        if(toFind == null){
            mav.addObject("error", "No such user exists");
            return mav;
        }
        //verify login information
        //probably should check with a hashed password instead of the actual
        if(toFind.getPassword() == request.getParameter("password")){
            //if correct password, redirect to the dashboard
            return new ModelAndView("redirect:/dashboard");
        }else{
            mav.addObject("error", "Incorret password");
            return mav;
        }

    }

}
