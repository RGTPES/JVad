package b4;

import b4.model.DichVu;
import b4.dto.BenhNhanDTO;
import b4.repo.BenhNhanRepository;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BenhNhanRepository repository = new BenhNhanRepository();
        List<BenhNhanDTO> ds = repository.layDanhSachBenhNhanDashboard(500, 0);

        for (BenhNhanDTO benhNhan : ds) {
            System.out.println("ma benh nhan: " + benhNhan.getMaBenhNhan());
            System.out.println("ten benh nhan: " + benhNhan.getTenBenhNhan());
            System.out.println("tuoi: " + benhNhan.getTuoi());
            System.out.println("gioi tinh: " + benhNhan.getGioiTinh());
            System.out.println("trang thai: " + benhNhan.getTrangThai());

            if (benhNhan.getDsDichVu().isEmpty()) {
                System.out.println("ds dich vu: rong");
            } else {
                System.out.println("ds dich vu:");
                for (DichVu dichVu : benhNhan.getDsDichVu()) {
                    System.out.println("- " + dichVu.getTenDichVu() + " | " + dichVu.getDonGia());
                }
            }

            System.out.println("--------------------------------");
        }
    }
}
