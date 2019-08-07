import database.landlord.PropertyDAO;
import model.landlord.Property;

public class Tester {

    private static PropertyDAO propertyDAO = new PropertyDAO();

    public static void main(String[] args) {
        Property property = new Property("name", "address", "city", "543", 5);
        propertyDAO.insertProperty(property);
        propertyDAO.printAllProperties();
    }

}
