package ex5;


import java.sql.Connection;
import java.sql.DriverManager;
public class DBContext {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/RHMS";
    private static final String USER = "root";
    private static final String PASSWORD = "Bibeo54321";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
