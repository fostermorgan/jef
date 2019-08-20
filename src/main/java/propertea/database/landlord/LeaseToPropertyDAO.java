package main.java.propertea.database.landlord;

import main.java.propertea.model.landlord.LeaseToProperty;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LeaseToPropertyDAO extends LandlordDAO {
    protected String table = "propertyLease";

    @Override
    public LeaseToProperty getByID(int ID) {
        ResultSet results;
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + table + " WHERE (propertyLeaseID=?)");
            statement.setInt(1, ID);
            results = statement.executeQuery();
            return new LeaseToProperty(results.getInt("propertyLeaseID"), results.getInt("propertyID"), results.getInt("leaseID"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
