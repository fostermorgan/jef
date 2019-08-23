package com.jef.propertea.model.landlord;

public class Renter {

    private int renterID;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    public Renter(int renterID, String firstName, String lastName, String email, String phoneNumber) {
        this.renterID = renterID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
