package data;

import java.sql.Connection;
import java.sql.DriverManager;

public class Manager implements IManager {

    @Override
    public Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Task", "postgres", "daniar11");
            return connection;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
