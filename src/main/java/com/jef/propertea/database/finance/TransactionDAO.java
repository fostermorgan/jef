package main.java.propertea.database.finance;

import main.java.propertea.model.finance.Transaction;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionDAO extends FinancialDAO {
    protected String table = "transactions";

    @Override
    public Transaction getByID(int ID) {
        ResultSet results;
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + table + " WHERE (transactionID=?)");
            statement.setInt(1, ID);
            results = statement.executeQuery();
            return new Transaction(results.getInt("transactionID"), results.getInt("transactionsToCategoriesID"), results.getInt("payeeID"),
                    results.getInt("userID"), results.getInt("typeID"), results.getDate("transactionDate"), results.getInt("checkNumber"),
                    results.getString("memo"), results.getDouble("transactionTotal"), results.getBoolean("isVoid"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
