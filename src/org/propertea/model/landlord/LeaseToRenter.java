package org.propertea.model.landlord;

public class LeaseToRenter {

    private int renterLeaseID;
    private int renterID;
    private int leaseID;

    public LeaseToRenter(int renterLeaseID, int renterID, int leaseID) {
        this.renterLeaseID = renterLeaseID;
        this.renterID = renterID;
        this.leaseID = leaseID;
    }
}
