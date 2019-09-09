package org.propertea.model;

import org.propertea.database.finance.UserDAO;
import org.propertea.database.landlord.PropertyDAO;
import org.propertea.model.finance.User;
import org.propertea.model.landlord.Property;

public class Tester {

    private static PropertyDAO propertyDAO = new PropertyDAO();
    private static UserDAO userDAO = new UserDAO();

    public static void main(String[] args) {
        Property property = new Property( "name", "address", "city", "543", 5);
        propertyDAO.insertProperty(property);
        propertyDAO.printAllProperties();

        User user = new User(1, "sellular13@gmail.com", "Hopsin1313", "admin");
        userDAO.insertUser(user);
        userDAO.printAllUsers();
    }

}
