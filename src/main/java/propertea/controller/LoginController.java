package main.java.propertea.controller;

import main.java.propertea.database.finance.UserDAO;
import main.java.propertea.model.finance.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
@RequestMapping("/login")
public class LoginController{

    private UserDAO userDAO;

    @Autowired
    public LoginController(UserDAO userDAO){
        this.userDAO = userDAO;
    }


    @RequestMapping(value="/loginVerification", method = RequestMethod.POST)
    public void loginVerification(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Im here");
        //changed return to void...I don't think this login controller doesn't need its own mav?
        ModelAndView mav = new ModelAndView("login");
        //find user from given email on login and store it into toFind

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User emailUser = userDAO.findUserByEmail(email);
        if(password.equals(emailUser.getPassword())) {
            //SUCCESS
            request.setAttribute("currentEmail", email); //with setAttribute() you can define a "key" and value pair so that you can get it in future using getAttribute("key")
            request.getRequestDispatcher("/dashboard.jsp").forward(request, response);//RequestDispatcher is used to send the control to the invoked page.

        } else{
            String errormessage;
            if(email.equalsIgnoreCase(emailUser.getEmail()))
                errormessage = "wrong password";
            else
                errormessage = "user doesn't exist with email";
            request.setAttribute("errMessage", errormessage); //If authenticateUser() function returnsother than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
            request.getRequestDispatcher("/index.jsp").forward(request, response);//forwarding the request
        }

    }

}
