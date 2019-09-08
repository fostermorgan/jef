package org.propertea.model.landlord;

public class Property {

    private int propertyID;
    private String propertyName;
    private String streetAddress;
    private String city;
    private String zip;
    private int unitNumber;

    public Property(int propertyID, String propertyName, String streetAddress, String city, String zip, int unitNumber) {
        this.propertyID = propertyID;
        this.propertyName = propertyName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.zip = zip;
        this.unitNumber = unitNumber;
    }

    public Property(String propertyName, String streetAddress, String city, String zip, int unitNumber) {
        this.propertyName = propertyName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.zip = zip;
        this.unitNumber = unitNumber;
    }

    public int getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(int propertyID) {
        this.propertyID = propertyID;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public int getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(int unitNumber) {
        this.unitNumber = unitNumber;
    }
}
