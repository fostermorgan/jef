package org.propertea.database.landlord;

import org.propertea.model.landlord.LeaseToRenter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LeaseToRenterDAO extends LandlordDAO {
    protected String table = "renterLease";

    @Override
    public LeaseToRenter getByID(int ID) {
        ResultSet results;
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + table + " WHERE (renterLeaseID=?)");
            statement.setInt(1, ID);
            results = statement.executeQuery();
            return new LeaseToRenter(results.getInt("renterLeaseID"), results.getInt("renterID"), results.getInt("leaseID"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
