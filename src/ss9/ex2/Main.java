package ss9.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    private static final String DATABASE_NAME = "Hospital_DB";
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Duyanh";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT medicine_name, stock FROM Pharmacy");
            while (rs.next()) {
                System.out.println(
                        "Thuoc: " + rs.getString("medicine_name") +
                                " | Ton kho: " + rs.getInt("stock")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
