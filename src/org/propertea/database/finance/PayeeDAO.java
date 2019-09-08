package org.propertea.database.finance;

import org.propertea.model.finance.Payee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PayeeDAO extends FinancialDAO {
    protected String table = "payees";

    @Override
    public Payee getByID(int ID) {
        ResultSet results;
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + table + " WHERE (payeeID=?)");
            statement.setInt(1, ID);
            results = statement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
