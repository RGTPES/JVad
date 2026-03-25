package b6.service;

import b6.util.DBContext;
import b6.entity.Bed;
import b6.entity.Patient;
import b6.repo.HospitalRepository;

import java.sql.Connection;
import java.sql.SQLException;

public class HospitalService {
    private final HospitalRepository repository;

    public HospitalService() {
        repository = new HospitalRepository();
    }

    public void xuatVien(int patientId, double amount) {
        Connection conn = null;

        try {
            conn = DBContext.getConnection();
            conn.setAutoCommit(false);

            Patient patient = repository.findPatientById(conn, patientId);
            if (patient == null) {
                throw new Exception("khong tim thay benh nhan");
            }

            if ("Da xuat vien".equalsIgnoreCase(patient.getStatus())) {
                throw new Exception("benh nhan nay da xuat vien truoc do");
            }

            Bed bed = repository.findBedByPatientId(conn, patientId);
            if (bed == null) {
                throw new Exception("khong tim thay giuong cua benh nhan");
            }

            int rowInvoice = repository.insertInvoice(conn, patientId, amount);
            if (rowInvoice == 0) {
                throw new Exception("khong tao duoc hoa don");
            }

            int rowPatient = repository.updatePatientStatus(conn, patientId, "Da xuat vien");
            if (rowPatient == 0) {
                throw new Exception("khong cap nhat duoc trang thai benh nhan");
            }

            int rowBed = repository.releaseBedByPatientId(conn, patientId);
            if (rowBed == 0) {
                throw new Exception("khong giai phong duoc giuong");
            }

            conn.commit();
            System.out.println("xuat vien thanh cong");

        } catch (Exception e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                System.out.println("rollback that bai: " + ex.getMessage());
            }

            System.out.println("xuat vien that bai: " + e.getMessage());

        } finally {
            try {
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("dong ket noi that bai: " + e.getMessage());
            }
        }
    }

    public void hienThiDuLieu() {
        try (Connection conn = DBContext.getConnection()) {
            repository.printPatients(conn);
            repository.printBeds(conn);
            repository.printInvoices(conn);
        } catch (SQLException e) {
            System.out.println("khong the hien thi du lieu: " + e.getMessage());
        }
    }
}
