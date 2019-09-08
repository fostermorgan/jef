package org.propertea.database.landlord;

import org.propertea.model.landlord.Property;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PropertyDAO extends LandlordDAO {
    protected String table = "property";

    public void printAllProperties(){
        try{
            PreparedStatement query = connection.prepareStatement("" +
                    "SELECT * FROM " + table);
            ResultSet results = query.executeQuery();
            while(results.next()){
                for(int i = 1; i <= 6; i++){
                    if(i > 1) System.out.println(", ");
                    String columVal = results.getString(i);
                    System.out.print(columVal + " ");
                }
                System.out.println();
            }
        } catch(SQLException e){
            System.out.println("SQL ERROR HELP");
            e.printStackTrace();
        }
    }

    public boolean insertProperty(Property property){
        try{
            PreparedStatement insert = connection.prepareStatement(
                    "INSERT INTO " + table + " (propertyName, streetAddress, city, zip, unitNumber) " +
                            "VALUES (?, ?, ?, ?, ?)");
            insert.setString(1, property.getPropertyName());
            insert.setString(2, property.getStreetAddress());
            insert.setString(3, property.getCity());
            insert.setString(4, property.getZip());
            insert.setInt(5, property.getUnitNumber());
            insert.executeUpdate();
            return true;
        } catch(SQLException e){
            System.out.println("SQL ERROR HELP");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Property getByID(int ID) {
        ResultSet results;
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + table + " WHERE (propertyID=?)");
            statement.setInt(1, ID);
            results = statement.executeQuery();
            return new Property(results.getInt("propertyID"), results.getString("propertyName"), results.getString("streetAddress"),
                    results.getString("city"), results.getString("zip"), results.getInt("unitNumber"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
