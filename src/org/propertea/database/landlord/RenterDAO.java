package org.propertea.database.landlord;

import org.propertea.model.landlord.Renter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RenterDAO extends LandlordDAO {

    protected String table = "renter";

    @Override
    public Renter getByID(int ID) {
        ResultSet results;
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + table + " WHERE (renterID=?)");
            statement.setInt(1, ID);
            results = statement.executeQuery();
            return new Renter(results.getInt("renterID"), results.getString("firstName"), results.getString("lastName"),
                    results.getString("email"), results.getString("phoneNumber"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
