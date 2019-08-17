package database.finance;

import model.finance.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO extends FinancialDAO{
    protected String table = "users";

    public String authenticateUser(User user){
        String success = "Invalid user credentials";
        String email = user.getEmail();
        String password = user.getEmail();

        String emailDB = "";
        String passwordDB = "";

        //get a list of all users
        ResultSet results = queryAll();
        try {
            //for each user from results, check if there is a matching email
            while(results.next()) {
                emailDB = results.getString("email");
                passwordDB = results.getString("password");

                if(email.equals(emailDB) && password.equals(passwordDB)) {
                    return "SUCCESS"; ////If the user entered values are already present in database, which means user has already registered so I will return SUCCESS message.
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //if never found corresponding email in results, will return error message
        return success;
    }


}
