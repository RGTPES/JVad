package b2;

import org.example.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public void thanhToanVienPhi(int patientId, int invoiceId, double amount) {
        try (Connection conn = DBContext.getConnection()) {

            conn.setAutoCommit(false);

            String sql1 = "UPDATE Patient_Wallet SET balance = balance - ? WHERE patient_id = ?";
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ps1.setDouble(1, amount);
            ps1.setInt(2, patientId);
            ps1.executeUpdate();

            String sql2 = "UPDATE Invoicess SET status = 'PAID' WHERE invoice_id = ?";
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.setInt(1, invoiceId);
            ps2.executeUpdate();

            conn.commit();
            System.out.println("thanh toan hoan tat");

        } catch (SQLException e) {
            System.out.println("loi he thong: khong the hoan tat thanh toan. chi tiet: " + e.getMessage());

            try (Connection conn = DBContext.getConnection()) {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
