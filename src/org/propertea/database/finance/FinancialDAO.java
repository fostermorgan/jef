package org.propertea.database.finance;


import org.propertea.database.DAO;

import java.sql.Connection;

abstract class FinancialDAO extends DAO {

    protected String password = "ProperTea";
    protected String username = "jef";
    protected String host = "10.8.1.7";
    protected String database = "financialDB";
    protected String port = "3306";

    protected Connection connection = loadConnection();

    protected Connection loadConnection(){
        return null;
        /*try{
            return DriverManager.getConnection("jdbc:mysql://" + host + "/" + database, username, password);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;*/
    }

}
