package hospital.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@SuppressWarnings("ALL")
public class conn {

    Connection connection;
    Statement statement;

    public conn() {
        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management_system", "root", "#Shivani007");
            statement = connection.createStatement();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

