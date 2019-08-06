package database;

import java.sql.*;

public abstract class DAO {

    protected Connection connection;
    protected String table;
    protected String password;
    protected String username;
    protected String host;
    protected String database;
    protected String port;

    public ResultSet queryAllInTable(){
        try{
            PreparedStatement query = connection.prepareStatement("SELECT * FROM " + table);
            return query.executeQuery();
        } catch(SQLException e){
            System.out.println("MYSQL EXCEPTION");
            e.printStackTrace();
        }
        return null;
    }

    protected Connection loadConnection(){
        try{
            return DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database,
                    username, password);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    protected String getTable(){
        return table;
    }

    protected Connection getConnection() {
        return connection;
    }
}
