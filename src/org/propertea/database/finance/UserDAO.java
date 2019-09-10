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
                        //If the user entered values are already present in org.propertea.database, which means user has already registered so I will return SUCCESS message.
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
        System.out.println(email);
        ResultSet results;
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + table + " WHERE (email=?)");
            statement.setString(1, email);
            results = statement.executeQuery();
            if(results.next() == false)
                return null; //Empty result set, no user found with email
            return new User(results.getInt("userID"), results.getString("email"), results.getString("password"), results.getString("role"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insertUser(User user){
        try{
            PreparedStatement insert = connection.prepareStatement(
                    "INSERT INTO " + table + " (email, password, role) " +
                            "VALUES (?, ?, ?)");
            insert.setString(1, user.getEmail());
            insert.setString(2, user.getPassword());
            insert.setString(3, user.getRole());
            insert.executeUpdate();
            return true;
        } catch(SQLException e){
            System.out.println("SQL ERROR HELP");
            e.printStackTrace();
        }
        return false;
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

    public void printAllUsers(){
        printAll(4);
    }

    public void printAll(int colNum){
        try{
            PreparedStatement query = connection.prepareStatement("" +
                    "SELECT * FROM " + table);
            ResultSet results = query.executeQuery();
            while(results.next()){
                for(int i = 1; i <= colNum; i++){
                    if(i > 1) System.out.println(", ");
                    String columVal = results.getString(i);
                    System.out.print(columVal + " ");
                }
                System.out.println();
            }
        } catch(SQLException e){
            System.out.println("SQL ERROR HELP");
            e.printStackTrace();
        }
    }
}
