package ex5;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    public List<Patients> getAll() {
        List<Patients> list = new ArrayList<>();
        String sql = "SELECT id, name, age, department,disease FROM Patients";

        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Patients(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("department"),
                        rs.getString("disease")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static void insert(Patients p) {
        String sql = "INSERT INTO Patients(name, age, department, disease) VALUES(?,?,?,?)";

        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getName());
            ps.setInt(2, p.getAge());
            ps.setString(3, p.getDepartment());
            ps.setString(4, p.getDisease());
            ps.executeUpdate();
            System.out.println("Insert thanh cong");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateDisease(int id, String disease) {
        String sql = "UPDATE Patients SET disease = ? WHERE id = ?";
        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, disease);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Update thanh cong");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public double discharge(int id) {
        double fee = 0;
        String sql = "{CALL CALCULATE_DISCHARGE_FEE(?, ?)}";
        try (Connection conn = DBContext.getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, id);
            cs.registerOutParameter(2, Types.DOUBLE);
            cs.execute();
            fee = cs.getDouble(2);
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Patients WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fee;
    }
}
