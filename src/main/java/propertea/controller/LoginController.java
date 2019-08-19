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
public class LoginController {

    @Autowired
    private UserDAO userDAO;

    public LoginController(UserDAO userDAO){
        this.userDAO = userDAO;
    }


    @RequestMapping(name="/loginVerification", method = RequestMethod.POST)
    public ModelAndView loginVerification(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //changed return to void...I don't think this login main.java.propertea.controller doesn't need its own mav?
        ModelAndView mav = new ModelAndView("login");
        //find user from given email on login and store it into toFind

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);

        String userValidate = userDAO.authenticateUser(user);

        if(userValidate.equals("SUCCESS")) //If function returns success string then user will be rooted to Home page
        {
            request.setAttribute("currentEmail", email); //with setAttribute() you can define a "key" and value pair so that you can get it in future using getAttribute("key")
            request.getRequestDispatcher("/dashboard.jsp").forward(request, response);//RequestDispatcher is used to send the control to the invoked page.
        }
        else {
            request.setAttribute("errMessage", userValidate); //If authenticateUser() function returnsother than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
            request.getRequestDispatcher("/index.jsp").forward(request, response);//forwarding the request
        }

        return null; //REMOVE ONCE REST OF METHOD IS DONE
//        User toFind = userDAO.findUserByEmail(email);
//
//        //if user doesn't exist display messsage and return to login page
//        if(toFind == null){
//            mav.addObject("error", "No such user exists");
//            return mav;
//        }
//        //verify login information
//        //probably should check with a hashed password instead of the actual
//        if(toFind.getPassword() == request.getParameter("password")){
//            //if correct password, redirect to the dashboard
//            return new ModelAndView("redirect:/dashboard");
//        }else{
//            mav.addObject("error", "Incorret password");
//            return mav;
//        }

    }

}
