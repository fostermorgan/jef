package com.jef.propertea.database.landlord;

import com.jef.propertea.model.landlord.Lease;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LeaseDAO extends LandlordDAO {
    private String table = "lease";

    public ArrayList<Lease> queryActiveLeases(){
        return queryLeaseByActivity(true);
    }

    private ArrayList<Lease> queryLeaseByActivity(boolean active){
        ArrayList<Lease> resultLeases = new ArrayList<>();
        try{
            PreparedStatement query = connection.prepareStatement("SELECT * FROM " + table + " WHERE (isActive=?)");
            query.setBoolean(1, active);
            ResultSet results = query.executeQuery();
            while(results.next()){
                int leaseID = results.getInt(1);
                Date startDate = results.getDate(2);
                Date endDate = results.getDate(3);
                Date rentDueDate = results.getDate(4);
                double rentAmount = results.getDouble(5);
                boolean isActive = results.getBoolean(6);
                resultLeases.add(new Lease(leaseID, startDate, endDate, rentDueDate, rentAmount, isActive));
            }
        } catch(SQLException e){
            System.out.println("SQL EXCEPTION");
            e.printStackTrace();
        }
        return resultLeases;
    }

    public ArrayList<Lease> queryInActiveLeases(){
        return queryLeaseByActivity(false);
    }

    @Override
    public Lease getByID(int ID) {
        ResultSet results;
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + table + " WHERE (leaseID=?)");
            statement.setInt(1, ID);
            results = statement.executeQuery();
            return new Lease(results.getInt("leaseID"), results.getDate("startDate"), results.getDate("endDate"), results.getDate("rentDueDate"),
                    results.getDouble("rentAmount"), results.getBoolean("isActive"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
