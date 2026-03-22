package ss9.ex6;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentRepository {

    // Thêm
    public void add(Appointment a) throws Exception {
        Connection conn = DatabaseConnection.getConnection();

        String sql = "INSERT INTO appointments (patient_name, appointment_date, doctor_name, status) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, a.getPatientName());
        ps.setDate(2, a.getAppointmentDate());
        ps.setString(3, a.getDoctorName());
        ps.setString(4, a.getStatus());

        ps.executeUpdate();
        conn.close();
    }

    // Sửa
    public void update(Appointment a) throws Exception {
        Connection conn = DatabaseConnection.getConnection();

        String sql = "UPDATE appointments SET patient_name=?, appointment_date=?, doctor_name=?, status=? WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, a.getPatientName());
        ps.setDate(2, a.getAppointmentDate());
        ps.setString(3, a.getDoctorName());
        ps.setString(4, a.getStatus());
        ps.setInt(5, a.getId());

        ps.executeUpdate();
        conn.close();
    }

    // Xóa
    public void delete(int id) throws Exception {
        Connection conn = DatabaseConnection.getConnection();

        String sql = "DELETE FROM appointments WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, id);
        ps.executeUpdate();
        conn.close();
    }

    // Lấy tất cả
    public List<Appointment> getAll() throws Exception {
        List<Appointment> list = new ArrayList<>();
        Connection conn = DatabaseConnection.getConnection();
        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery("SELECT * FROM appointments");

        while (rs.next()) {
            list.add(new Appointment(
                    rs.getInt("id"),
                    rs.getString("patient_name"),
                    rs.getDate("appointment_date"),
                    rs.getString("doctor_name"),
                    rs.getString("status")
            ));
        }

        conn.close();
        return list;
    }
}
