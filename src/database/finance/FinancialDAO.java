package database.finance;

import database.DAO;

import java.sql.Connection;

abstract class FinancialDAO extends DAO {

    protected String password = "jakerifos2019";
    protected String username = "jef";
    protected String host = "localhost";
    protected String database = "financialDB";
    protected String port = "3306";

    protected Connection connection = loadConnection();

}
