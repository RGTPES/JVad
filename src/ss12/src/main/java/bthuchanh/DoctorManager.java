package bthuchanh;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoctorManager {

    public List<Doctor> findDoctorBySpecialty(String specialty) {
        List<Doctor> doctors = new ArrayList<>();
        String sql = "select * from Doctors where specialty = ?";

        try (
                Connection conn = DBContext.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setString(1, specialty);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Doctor doctor = new Doctor(
                            rs.getInt("doctor_id"),
                            rs.getString("full_name"),
                            rs.getString("specialty"),
                            rs.getInt("experience_years"),
                            rs.getDouble("base_salary"),
                            rs.getString("password")
                    );
                    doctors.add(doctor);
                }
            }

        } catch (SQLException e) {
            System.out.println("Loi khi tim bac si theo chuyen khoa.");
            e.printStackTrace();
        }

        return doctors;
    }

    public void updatePassword(int id, String newPass) {
        String sql = "update Doctors set password = ? where doctor_id = ?";

        try (
                Connection conn = DBContext.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setString(1, newPass);
            pstmt.setInt(2, id);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected == 0) {
                System.out.println("Khong tim thay bac si co id = " + id);
            } else {
                System.out.println("Cap nhat mat khau thanh cong!");
            }

        } catch (SQLException e) {
            System.out.println("Loi khi cap nhat mat khau.");
            e.printStackTrace();
        }
    }

    public void calculateDutyFee(int doctorId) {
        String sql = "{call calculate_duty_fee(?, ?)}";

        try (
                Connection conn = DBContext.getConnection();
                CallableStatement cstmt = conn.prepareCall(sql)
        ) {
            cstmt.setInt(1, doctorId);
            cstmt.registerOutParameter(2, Types.DOUBLE);

            cstmt.execute();

            double dutyFee = cstmt.getDouble(2);

            if (dutyFee == 0) {
                System.out.println("Khong tim thay bac si hoac tien truc = 0.");
            } else {
                System.out.println("Tien truc ca dua tren kinh nghiem: " + String.format("%,.0f", dutyFee) + " VNĐ");
            }

        } catch (SQLException e) {
            System.out.println("Loi khi tinh tien truc.");
            e.printStackTrace();
        }
    }

    public void displayDoctors(List<Doctor> doctors) {
        if (doctors.isEmpty()) {
            System.out.println("Khong tim thay bac si nao.");
            return;
        }

        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== QUAN LY BAC SI =====");
            System.out.println("1. Tim bac si theo chuyen khoa");
            System.out.println("2. Cap nhat mat khau");
            System.out.println("3. Tinh tien truc");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhap chuyen khoa: ");
                    String specialty = sc.nextLine();
                    List<Doctor> doctors = findDoctorBySpecialty(specialty);
                    displayDoctors(doctors);
                    break;

                case 2:
                    System.out.print("Nhap id bac si: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhap mat khau moi: ");
                    String newPass = sc.nextLine();
                    updatePassword(id, newPass);
                    break;

                case 3:
                    System.out.print("Nhap id bac si: ");
                    int doctorId = Integer.parseInt(sc.nextLine());
                    calculateDutyFee(doctorId);
                    break;

                case 0:
                    System.out.println("Thoat chuong trinh.");
                    break;

                default:
                    System.out.println("Lua chon khong hop le.");
            }

        } while (choice != 0);
    }
}