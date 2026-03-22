package ss9.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility {
    private static final String DATABASE_NAME = "QUANLYHOCTAP";
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/"+DATABASE_NAME;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Duyanh";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            //Nạp lớp thư viện
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(CONNECTION_STRING,USERNAME,PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    public static void main(String[] args) {
        System.out.println(getConnection());
    }
}