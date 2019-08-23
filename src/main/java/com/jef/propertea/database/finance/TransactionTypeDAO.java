package com.jef.propertea.database.finance;

import com.jef.propertea.model.finance.TransactionType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionTypeDAO extends FinancialDAO {
    protected String table = "transactionTypes";

    @Override
    public TransactionType getByID(int ID) {
        ResultSet results;
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + table + " WHERE (typeID=?)");
            statement.setInt(1, ID);
            results = statement.executeQuery();
            return new TransactionType(results.getInt("typeID"), results.getString("typeName"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
