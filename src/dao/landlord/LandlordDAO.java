package dao.landlord;

import java.sql.Connection;
import java.sql.DriverManager;

abstract class LandlordDAO {

    private Connection connection = loadConnection();

    private Connection loadConnection(){
        try{
            String password = "jakerifos2019";
            String username = "jef";
            String host = "localhost";
            String database = "landlordDB";
            String port = "3306";
            return DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database,
                    username, password);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
