package b6.repo;


import b6.entity.Bed;
import b6.entity.Invoice;
import b6.entity.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HospitalRepository {

    public int insertInvoice(Connection conn, int patientId, double amount) throws SQLException {
        String sql = "insert into invoices(patient_id, amount) values (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, patientId);
            ps.setDouble(2, amount);
            return ps.executeUpdate();
        }
    }

    public int updatePatientStatus(Connection conn, int patientId, String status) throws SQLException {
        String sql = "update patients set status = ? where patient_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setInt(2, patientId);
            return ps.executeUpdate();
        }
    }

    public int releaseBedByPatientId(Connection conn, int patientId) throws SQLException {
        String sql = "update beds set patient_id = null, status = 'Trong' where patient_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, patientId);
            return ps.executeUpdate();
        }
    }

    public Patient findPatientById(Connection conn, int patientId) throws SQLException {
        String sql = "select patient_id, patient_name, status from patients where patient_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, patientId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Patient(
                            rs.getInt("patient_id"),
                            rs.getString("patient_name"),
                            rs.getString("status")
                    );
                }
            }
        }
        return null;
    }

    public Bed findBedByPatientId(Connection conn, int patientId) throws SQLException {
        String sql = "select bed_id, patient_id, status from beds where patient_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, patientId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Bed(
                            rs.getString("bed_id"),
                            (Integer) rs.getObject("patient_id"),
                            rs.getString("status")
                    );
                }
            }
        }
        return null;
    }

    public void printPatients(Connection conn) throws SQLException {
        String sql = "select * from patients";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("bang patients:");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("patient_id") + " | " +
                                rs.getString("patient_name") + " | " +
                                rs.getString("status")
                );
            }
        }
    }

    public void printBeds(Connection conn) throws SQLException {
        String sql = "select * from beds";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("bang beds:");
            while (rs.next()) {
                System.out.println(
                        rs.getString("bed_id") + " | " +
                                rs.getString("patient_id") + " | " +
                                rs.getString("status")
                );
            }
        }
    }

    public void printInvoices(Connection conn) throws SQLException {
        String sql = "select * from invoices";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("bang invoices:");
            while (rs.next()) {
                Invoice invoice = new Invoice(
                        rs.getInt("invoice_id"),
                        rs.getInt("patient_id"),
                        rs.getDouble("amount"),
                        rs.getTimestamp("created_date")
                );

                System.out.println(
                        invoice.getInvoiceId() + " | " +
                                invoice.getPatientId() + " | " +
                                invoice.getAmount() + " | " +
                                invoice.getCreatedDate()
                );
            }
        }
    }
}
