package b5.DAO;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import b5.entity.Bed;
import b5.util.DatabaseHelper;

public class ReceptionControllerDao {
    public List<Bed> layDanhSachGiuongTrong() {
        List<Bed> ds = new ArrayList<>();
        String sql = "select ma_giuong, ten_giuong, trang_thai from giuong_benh where trang_thai = 'trong' order by ma_giuong";

        try (
                Connection conn = DatabaseHelper.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Bed bed = new Bed(
                        rs.getInt("ma_giuong"),
                        rs.getString("ten_giuong"),
                        rs.getString("trang_thai"));
                ds.add(bed);
            }
        } catch (SQLException e) {
            System.out.println("khong the tai danh sach giuong trong: " + e.getMessage());
        }

        return ds;
    }

    public boolean tiepNhanBenhNhan(String tenBenhNhan, int tuoi, int maGiuong, double soTienTamUng) {
        Connection conn = null;
        PreparedStatement psCheckBed = null;
        PreparedStatement psInsertPatient = null;
        PreparedStatement psUpdateBed = null;
        PreparedStatement psInsertFinance = null;
        ResultSet rs = null;

        try {
            conn = DatabaseHelper.getConnection();
            conn.setAutoCommit(false);

            String sqlCheckBed = "select trang_thai from giuong_benh where ma_giuong = ?";
            psCheckBed = conn.prepareStatement(sqlCheckBed);
            psCheckBed.setInt(1, maGiuong);
            rs = psCheckBed.executeQuery();

            if (!rs.next()) {
                throw new Exception("ma giuong khong ton tai");
            }

            String trangThai = rs.getString("trang_thai");
            if (!"trong".equalsIgnoreCase(trangThai)) {
                throw new Exception("giuong nay khong con trong");
            }

            String sqlInsertPatient = "insert into benh_nhan(ten_benh_nhan, tuoi, ma_giuong) values (?, ?, ?)";
            psInsertPatient = conn.prepareStatement(sqlInsertPatient, Statement.RETURN_GENERATED_KEYS);
            psInsertPatient.setString(1, tenBenhNhan);
            psInsertPatient.setInt(2, tuoi);
            psInsertPatient.setInt(3, maGiuong);

            int rowPatient = psInsertPatient.executeUpdate();
            if (rowPatient == 0) {
                throw new Exception("khong the tao ho so benh nhan");
            }

            int maBenhNhan;
            try (ResultSet generatedKeys = psInsertPatient.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    maBenhNhan = generatedKeys.getInt(1);
                } else {
                    throw new Exception("khong lay duoc ma benh nhan vua tao");
                }
            }

            String sqlUpdateBed = "update giuong_benh set trang_thai = 'da co nguoi' where ma_giuong = ? and trang_thai = 'trong'";
            psUpdateBed = conn.prepareStatement(sqlUpdateBed);
            psUpdateBed.setInt(1, maGiuong);

            int rowBed = psUpdateBed.executeUpdate();
            if (rowBed == 0) {
                throw new Exception("cap nhat giuong that bai, co the giuong da duoc nguoi khac chon");
            }

            String sqlInsertFinance = "insert into tai_chinh(ma_benh_nhan, so_tien, noi_dung) values (?, ?, ?)";
            psInsertFinance = conn.prepareStatement(sqlInsertFinance);
            psInsertFinance.setInt(1, maBenhNhan);
            psInsertFinance.setDouble(2, soTienTamUng);
            psInsertFinance.setString(3, "thu tam ung vien phi");

            int rowFinance = psInsertFinance.executeUpdate();
            if (rowFinance == 0) {
                throw new Exception("khong the lap phieu thu tam ung");
            }

            conn.commit();
            return true;

        } catch (Exception e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    System.out.println("rollback that bai: " + ex.getMessage());
                }
            }
            System.out.println("tiep nhan that bai: " + e.getMessage());
            return false;

        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (psCheckBed != null)
                    psCheckBed.close();
                if (psInsertPatient != null)
                    psInsertPatient.close();
                if (psUpdateBed != null)
                    psUpdateBed.close();
                if (psInsertFinance != null)
                    psInsertFinance.close();

                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("loi dong tai nguyen: " + e.getMessage());
            }
        }
    }
}
