package database.finance;

import model.finance.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO extends FinancialDAO{
    protected String table = "users";

    public User findUserByEmail(String email){
        User toFind = null;
        //get a list of all users
        ResultSet results = queryAll();
        try {
            results.last();
            int numberOfRows = results.getRow();
            results.beforeFirst();
            //for each user from results, check if there is a matching email
            while(results.next()) {
                if(results.getString("email") == email){
                    toFind.setEmail(results.getString("email"));
                    toFind.setRole(results.getString("role"));
                    return toFind;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //if never found corresponding email in results, will return the intitialized null User
        return toFind;
    }


}
