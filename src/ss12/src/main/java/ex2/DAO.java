package ex2;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DAO {
    public void updateVital(int id, double temp, int heartRate) {
        String sql = "UPDATE Vitals SET temperature = ?, heart_rate = ? WHERE p_id = ?";
        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, temp);
            ps.setInt(2, heartRate);
            ps.setInt(3, id);
            ps.executeUpdate();
            System.out.println("Update thanh cong");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
