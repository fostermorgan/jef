package org.propertea.model.landlord;

public class LeaseToProperty {

    private int propertyLeaseID;
    private int propertyID;
    private int leaseID;

    public LeaseToProperty(int propertyLeaseID, int propertyID, int leaseID) {
        this.propertyLeaseID = propertyLeaseID;
        this.propertyID = propertyID;
        this.leaseID = leaseID;
    }
}
