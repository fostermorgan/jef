package main.java.propertea.database.finance;

import main.java.propertea.model.finance.ClassFilter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassFilterDAO extends FinancialDAO {
    protected String table = "classFilters";

    @Override
    public ClassFilter getByID(int ID) {
        ResultSet results;
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + table + " WHERE (classFilterID=?)");
            statement.setInt(1, ID);
            results = statement.executeQuery();
            return new ClassFilter(results.getInt("classFilterID"), results.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
