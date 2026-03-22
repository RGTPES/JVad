package ss9.ex3;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Main {

    private static final String DATABASE_NAME = "Hospital_DB";
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Duyanh";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;

        String inputId = "Bed_999"; // test ma giuong

        try {
            conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);

            String sql = "UPDATE Beds SET bed_status = 'Occupied' WHERE bed_id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, inputId);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected == 0) {
                System.out.println("Giuong ko ton tai");
            } else {
                System.out.println("Cap nhat thanh cong");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}