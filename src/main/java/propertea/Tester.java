package main.java.propertea;

import main.java.propertea.database.landlord.PropertyDAO;
import main.java.propertea.model.landlord.Property;

public class Tester {

    private static PropertyDAO propertyDAO = new PropertyDAO();

    public static void main(String[] args) {
        Property property = new Property( "name", "address", "city", "543", 5);
        propertyDAO.insertProperty(property);
        propertyDAO.printAllProperties();
    }

}
