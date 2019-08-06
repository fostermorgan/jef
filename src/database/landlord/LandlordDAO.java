package database.landlord;

import database.DAO;

import java.sql.Connection;

abstract class LandlordDAO extends DAO {

    protected String password = "jakerifos2019";
    protected String username = "jef";
    protected String host = "localhost";
    protected String database = "landlordDB";
    protected String port = "3306";

    protected Connection connection = loadConnection();

}
