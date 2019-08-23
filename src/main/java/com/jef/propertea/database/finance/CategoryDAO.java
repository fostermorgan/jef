package com.jef.propertea.database.finance;

import com.jef.propertea.model.finance.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryDAO extends FinancialDAO {
    protected String table = "categories";

    @Override
    public Category getByID(int ID) {
        ResultSet results;
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + table + " WHERE (userID=?)");
            statement.setInt(1, ID);
            results = statement.executeQuery();
            return new Category(results.getInt("categoryID"), results.getString("categoryName"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
