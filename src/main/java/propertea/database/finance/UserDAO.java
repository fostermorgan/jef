package main.java.propertea.database.finance;

import main.java.propertea.model.finance.User;

import java.sql.PreparedStatement;
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
                    return "SUCCESS"; ////If the user entered values are already present in main.java.propertea.database, which means user has already registered so I will return SUCCESS message.
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //if never found corresponding email in results, will return error message
        return success;
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
