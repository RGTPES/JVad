package ex4;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class DAO {
    public void insertBatch(List<Result> list) {
        String sql = "INSERT INTO Results(patients_id, value) VALUES(?, ?)";
        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            for (Result tr : list) {
                ps.setInt(1, tr.getPatientId());
                ps.setDouble(2, tr.getValue());
                ps.addBatch();
            }
            ps.executeBatch();
            System.out.println("Insert thanh cong");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
