package org.propertea.database.finance;

import org.propertea.model.finance.User;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component("userDAO")
public class UserDAO extends FinancialDAO{
    protected String table = "users";

    public User authenticateUser(String email, String password){
        //get a list of all users
        ResultSet results = queryAll();
        try {
            //for each user from results, check if there is a matching email
            while(results.next()) {
                String emailDB = results.getString("email");
                String passwordDB = results.getString("password");

                if(email.equalsIgnoreCase(emailDB)) {
                    if(password.equals(passwordDB)){
                        return new User(results.getInt("userID"), email, password, results.getString("role"));
                        ////If the user entered values are already present in org.propertea.database, which means user has already registered so I will return SUCCESS message.
                    }
                    //User input wrong password ERROR
                }
            }
            //User doesn't exist with given email ERROR
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //if never found corresponding email in results, will return error message
        return null;
    }

    public User findUserByEmail(String email){
        ResultSet results;
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + table + " WHERE (email=?)");
            statement.setString(1, email);
            results = statement.executeQuery();
            return new User(results.getInt("userID"), results.getString("email"), results.getString("password"), results.getString("role"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getByID(int ID) {
        ResultSet results;
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + table + " WHERE (userID=?)");
            statement.setInt(1, ID);
            results = statement.executeQuery();
            return new User(results.getInt("userID"), results.getString("email"), results.getString("password"), results.getString("role"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
