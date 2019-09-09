package org.propertea.database.landlord;

import org.propertea.database.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

abstract class LandlordDAO extends DAO {

    protected String password = "ProperTea";
    protected String username = "jef";
    protected String host = "10.8.1.7";
    protected String database = "landlordDB";

    protected Connection connection = loadConnection();

    protected Connection loadConnection(){
        try{
            return DriverManager.getConnection("jdbc:mysql://" + host + "/" + database, username, password);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
