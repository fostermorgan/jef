package main.java.propertea.database.finance;

import main.java.propertea.model.finance.TransactionToCategory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionToCategoryDAO extends FinancialDAO {
    protected String table = "transactionsCategories";

    @Override
    public TransactionToCategory getByID(int ID) {
        ResultSet results;
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + table + " WHERE (transactionToCategoriesID=?)");
            statement.setInt(1, ID);
            results = statement.executeQuery();
            return new TransactionToCategory(results.getInt("transactionsToCategoriesID"), results.getInt("transactionsID"),
                    results.getInt("categoryID"), results.getInt("classID"), results.getString("description"), results.getDouble("amount"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
