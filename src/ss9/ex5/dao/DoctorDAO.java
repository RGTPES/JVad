package ss9.ex5.dao;


import ss9.ex5.model.Doctor;
import java.sql.*;
import java.util.*;

public class DoctorDAO {

    private Connection conn;

    public DoctorDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Doctor> getAll() throws Exception {
        List<Doctor> list = new ArrayList<>();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM Doctors");

        while (rs.next()) {
            list.add(new Doctor(
                    rs.getString("doctor_id"),
                    rs.getString("full_name"),
                    rs.getString("specialty")
            ));
        }
        return list;
    }

    public void add(Doctor d) throws Exception {
        String sql = "INSERT INTO Doctors VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, d.getDoctor_id());
        ps.setString(2, d.getFull_name());
        ps.setString(3, d.getSpecialty());
        ps.executeUpdate();
    }

    public void stats() throws Exception {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(
                "SELECT specialty, COUNT(*) total FROM Doctors GROUP BY specialty"
        );

        while (rs.next()) {
            System.out.println(rs.getString("specialty") + ": " + rs.getInt("total"));
        }
    }
}