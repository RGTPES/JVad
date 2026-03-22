package ss9.ex6;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private static final String DATABASE_NAME = "MedicalAppointmentDB";
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Duyanh";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
    }
}
