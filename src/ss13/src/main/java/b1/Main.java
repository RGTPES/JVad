package b1;

import org.example.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Main {
    public void capPhatThuoc(int medicineId, int patientId) {
        String sqlUpdateInventory =
                "UPDATE Medicine_Inventory SET quantity = quantity - 1 WHERE medicine_id = ?";
        String sqlInsertHistory =
                "INSERT INTO Prescription_History (patient_id, medicine_id, date) VALUES (?, ?, NOW())";
        try (Connection conn = DBContext.getConnection()) {
            conn.setAutoCommit(false);
            try (
                    PreparedStatement ps1 = conn.prepareStatement(sqlUpdateInventory);
                    PreparedStatement ps2 = conn.prepareStatement(sqlInsertHistory);
            ) {
                ps1.setInt(1, medicineId);
                int rows = ps1.executeUpdate();
                if (rows == 0) {
                    throw new RuntimeException("khong tim thay thuoc");
                }
                ps2.setInt(1, patientId);
                ps2.setInt(2, medicineId);
                ps2.executeUpdate();
                conn.commit();
                System.out.println("cap phat thuoc thanh cong");
            } catch (Exception e) {
                conn.rollback();
                System.out.println("rollback do loi: " + e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
