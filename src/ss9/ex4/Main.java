package ss9.ex4;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {

    private static final String DATABASE_NAME = "Hospital_DB";
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Duyanh";

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
            String patientName = "huy";
            String sql = "SELECT * FROM Patients WHERE full_name = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, patientName);
            rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("Ten: " + rs.getString("full_name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
