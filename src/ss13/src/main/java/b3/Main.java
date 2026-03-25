package b3;
import b3.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Main {
    public void xuatVienVaThanhToan(int maBenhNhan, double tienVienPhi) {
        Connection conn = null;
        PreparedStatement psSelect = null;
        PreparedStatement psUpdateBalance = null;
        PreparedStatement psUpdateBed = null;
        PreparedStatement psUpdatePatient = null;
        ResultSet rs = null;

        try {
            conn = DBContext.getConnection();
            conn.setAutoCommit(false);
            String sqlSelect = "select balance, bed_id from patients where patient_id = ?";
            psSelect = conn.prepareStatement(sqlSelect);
            psSelect.setInt(1, maBenhNhan);
            rs = psSelect.executeQuery();

            if (!rs.next()) {
                throw new Exception("benh nhan khong ton tai");
            }

            double soDuHienTai = rs.getDouble("balance");
            int maGiuong = rs.getInt("bed_id");

            /*
             * bay 1 - bay logic nghiep vu
             * khong duoc phep tru tien neu so du < tien vien phi
             * neu vi pham thi nem exception de rollback toan bo
             */
            if (soDuHienTai < tienVienPhi) {
                throw new Exception("so du khong du de thanh toan vien phi");
            }

            String sqlUpdateBalance = "update patients set balance = balance - ? where patient_id = ?";
            psUpdateBalance = conn.prepareStatement(sqlUpdateBalance);
            psUpdateBalance.setDouble(1, tienVienPhi);
            psUpdateBalance.setInt(2, maBenhNhan);
            int rowBalance = psUpdateBalance.executeUpdate();

            /*
             * bay 2 - bay du lieu ao
             * executeUpdate() = 0 nghia la khong co dong nao duoc cap nhat
             * jdbc khong tu nem loi, nen phai chu dong kiem tra va nem exception
             */
            if (rowBalance == 0) {
                throw new Exception("khong cap nhat duoc so du benh nhan");
            }

            String sqlUpdateBed = "update beds set status = 'trong' where bed_id = ?";
            psUpdateBed = conn.prepareStatement(sqlUpdateBed);
            psUpdateBed.setInt(1, maGiuong);
            int rowBed = psUpdateBed.executeUpdate();

            /*
             * bay 2 - bay du lieu ao
             * neu row affected = 0 thi giao dich vo nghia, phai rollback
             */
            if (rowBed == 0) {
                throw new Exception("khong cap nhat duoc trang thai giuong");
            }

            String sqlUpdatePatient = "update patients set status = 'da xuat vien' where patient_id = ?";
            psUpdatePatient = conn.prepareStatement(sqlUpdatePatient);
            psUpdatePatient.setInt(1, maBenhNhan);
            int rowPatient = psUpdatePatient.executeUpdate();

            /*
             * bay 2 - bay du lieu ao
             * neu khong co dong nao bi tac dong thi xem nhu that bai
             */
            if (rowPatient == 0) {
                throw new Exception("khong cap nhat duoc trang thai benh nhan");
            }

            conn.commit();
            System.out.println("xuat vien va thanh toan thanh cong");

        } catch (Exception e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            System.out.println("xuat vien va thanh toan that bai: " + e.getMessage());

        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (psSelect != null)
                    psSelect.close();
                if (psUpdateBalance != null)
                    psUpdateBalance.close();
                if (psUpdateBed != null)
                    psUpdateBed.close();
                if (psUpdatePatient != null)
                    psUpdatePatient.close();

                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
