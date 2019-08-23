package com.jef.propertea.model.landlord;

import java.sql.Date;
public class Lease {

    private int leaseID;
    private Date startDate;
    private Date endDate;
    private Date rentDueDate;
    private double rentAmount;
    private boolean isActive;

    public Lease(int leaseID, Date startDate, Date endDate, Date rentDueDate, double rentAmount, boolean isActive) {
        this.leaseID = leaseID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rentDueDate = rentDueDate;
        this.rentAmount = rentAmount;
        this.isActive = isActive;
    }
}
