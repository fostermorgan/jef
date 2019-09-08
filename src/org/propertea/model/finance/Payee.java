package org.propertea.model.finance;

public class Payee {

    private int payeeID;
    private String name;
    private String address;
    private String city;
    private String zip;

    public Payee(int payeeID, String name, String address, String city, String zip) {
        this.payeeID = payeeID;
        this.name = name;
        this.address = address;
        this.city = city;
        this.zip = zip;
    }
}
