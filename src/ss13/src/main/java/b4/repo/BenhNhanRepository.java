package b4.repo;


import b4.model.DichVu;
import b4.dto.BenhNhanDTO;
import b4.util.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BenhNhanRepository {

    public List<BenhNhanDTO> layDanhSachBenhNhanDashboard(int limit, int offset) {
        List<BenhNhanDTO> dsBenhNhan = new ArrayList<>();
        Map<Integer, BenhNhanDTO> mapBenhNhan = new HashMap<>();

        String sqlBenhNhan = """
                select maBenhNhan, tenBenhNhan, tuoi, gioiTinh, trangThai
                from BenhNhan
                order by maBenhNhan
                limit ? offset ?
                """;

        try (
                Connection conn = DBContext.getConnection();
                PreparedStatement psBenhNhan = conn.prepareStatement(sqlBenhNhan)
        ) {
            psBenhNhan.setInt(1, limit);
            psBenhNhan.setInt(2, offset);

            try (ResultSet rsBenhNhan = psBenhNhan.executeQuery()) {

                while (rsBenhNhan.next()) {
                    int maBenhNhan = rsBenhNhan.getInt("maBenhNhan");

                    BenhNhanDTO benhNhan = new BenhNhanDTO();
                    benhNhan.setMaBenhNhan(maBenhNhan);
                    benhNhan.setTenBenhNhan(rsBenhNhan.getString("tenBenhNhan"));
                    benhNhan.setTuoi(rsBenhNhan.getInt("tuoi"));
                    benhNhan.setGioiTinh(rsBenhNhan.getString("gioiTinh"));
                    benhNhan.setTrangThai(rsBenhNhan.getString("trangThai"));
                    benhNhan.setDsDichVu(new ArrayList<>());

                    dsBenhNhan.add(benhNhan);
                    mapBenhNhan.put(maBenhNhan, benhNhan);
                }
            }

            if (dsBenhNhan.isEmpty()) {
                return dsBenhNhan;
            }

            StringBuilder sqlDichVu = new StringBuilder("""
                    select maDichVu, tenDichVu, donGia, maBenhNhan
                    from DichVuSuDung
                    where maBenhNhan in (
                    """);

            for (int i = 0; i < dsBenhNhan.size(); i++) {
                sqlDichVu.append("?");
                if (i < dsBenhNhan.size() - 1) {
                    sqlDichVu.append(", ");
                }
            }
            sqlDichVu.append(")");

            try (PreparedStatement psDichVu = conn.prepareStatement(sqlDichVu.toString())) {

                for (int i = 0; i < dsBenhNhan.size(); i++) {
                    psDichVu.setInt(i + 1, dsBenhNhan.get(i).getMaBenhNhan());
                }

                try (ResultSet rsDichVu = psDichVu.executeQuery()) {
                    while (rsDichVu.next()) {
                        int maBenhNhan = rsDichVu.getInt("maBenhNhan");

                        BenhNhanDTO benhNhan = mapBenhNhan.get(maBenhNhan);
                        if (benhNhan != null) {
                            DichVu dichVu = new DichVu();
                            dichVu.setMaDichVu(rsDichVu.getInt("maDichVu"));
                            dichVu.setTenDichVu(rsDichVu.getString("tenDichVu"));
                            dichVu.setDonGia(rsDichVu.getDouble("donGia"));

                            /*
                             * xu ly bay 2:
                             * benh nhan co the khong co dich vu nao.
                             * vi query benh nhan da chay truoc nen benh nhan van nam trong list.
                             * o day chi add dich vu neu co ban ghi trong DichVuSuDung.
                             * dsDichVu da duoc khoi tao san = new ArrayList<>(),
                             * nen benh nhan khong co dich vu van hien thi binh thuong
                             * va khong bi NullPointerException.
                             */
                            benhNhan.getDsDichVu().add(dichVu);
                        }
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dsBenhNhan;
    }
}
