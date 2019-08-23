package com.jef.propertea.database;

import java.sql.*;

public abstract class DAO {

    protected Connection connection;
    protected String table;
    protected String password;
    protected String username;
    protected String host;
    protected String port;
    protected String database;

    public ResultSet queryAll(){
        try{
            PreparedStatement query = connection.prepareStatement("SELECT * FROM " + table);
            return query.executeQuery();
        } catch(SQLException e){
            System.out.println("MYSQL EXCEPTION");
            e.printStackTrace();
        }
        return null;
    }

    abstract protected Connection loadConnection();

    abstract public Object getByID(int ID);

    protected String getTable(){
        return table;
    }

    protected Connection getConnection() {
        return connection;
    }
}
