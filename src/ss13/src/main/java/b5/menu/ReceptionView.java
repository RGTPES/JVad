package b5.menu;


import b5.DAO.ReceptionControllerDao;
import b5.entity.Bed;
import java.util.List;
import java.util.Scanner;

public class ReceptionView {
    private final ReceptionControllerDao controller;
    private final Scanner scanner;

    public ReceptionView() {
        controller = new ReceptionControllerDao();
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            showMenu();
            int choice = readInt("chon chuc nang: ");

            switch (choice) {
                case 1:
                    hienThiGiuongTrong();
                    break;
                case 2:
                    tiepNhanBenhNhan();
                    break;
                case 3:
                    System.out.println("tam biet");
                    return;
                default:
                    System.out.println("lua chon khong hop le");
            }
        }
    }

    private void showMenu() {
        System.out.println("\n============================");
        System.out.println("he thong le tan rikkei hospital");
        System.out.println("1. xem tinh trang giuong trong");
        System.out.println("2. tiep nhan benh nhan");
        System.out.println("3. thoat");
        System.out.println("============================");
    }

    private void hienThiGiuongTrong() {
        List<Bed> ds = controller.layDanhSachGiuongTrong();

        if (ds.isEmpty()) {
            System.out.println("khong co giuong trong");
            return;
        }

        System.out.println("\n--- danh sach giuong trong ---");
        for (Bed bed : ds) {
            System.out.println("ma giuong: " + bed.getMaGiuong()
                    + " | ten giuong: " + bed.getTenGiuong()
                    + " | trang thai: " + bed.getTrangThai());
        }
    }

    private void tiepNhanBenhNhan() {
        System.out.println("\n--- tiep nhan benh nhan ---");

        String tenBenhNhan = readNonEmptyString("nhap ten benh nhan: ");
        int tuoi = readPositiveInt("nhap tuoi: ");
        int maGiuong = readPositiveInt("nhap ma giuong muon chon: ");
        double soTienTamUng = readPositiveDouble("nhap so tien tam ung: ");

        boolean result = controller.tiepNhanBenhNhan(tenBenhNhan, tuoi, maGiuong, soTienTamUng);

        if (result) {
            System.out.println("tiep nhan benh nhan thanh cong");
        } else {
            System.out.println("khong the hoan tat tiep nhan, du lieu da duoc khoi phuc an toan");
        }
    }

    private int readInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (Exception e) {
                System.out.println("vui long nhap so nguyen hop le");
            }
        }
    }

    private int readPositiveInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value <= 0) {
                    System.out.println("gia tri phai lon hon 0");
                    continue;
                }
                return value;
            } catch (Exception e) {
                System.out.println("vui long nhap so nguyen hop le");
            }
        }
    }

    private double readPositiveDouble(String message) {
        while (true) {
            try {
                System.out.print(message);
                double value = Double.parseDouble(scanner.nextLine().trim());
                if (value <= 0) {
                    System.out.println("so tien phai lon hon 0");
                    continue;
                }
                return value;
            } catch (Exception e) {
                System.out.println("vui long nhap so tien hop le");
            }
        }
    }

    private String readNonEmptyString(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("khong duoc de trong");
        }
    }
}
