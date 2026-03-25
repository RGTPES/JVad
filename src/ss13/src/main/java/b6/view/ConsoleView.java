package b6.view;


import b6.service.HospitalService;

import java.util.Scanner;

public class ConsoleView {
    private final HospitalService service;
    private final Scanner scanner;

    public ConsoleView() {
        service = new HospitalService();
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            showMenu();
            int choice = readInt("chon chuc nang: ");

            switch (choice) {
                case 1:
                    service.hienThiDuLieu();
                    break;
                case 2:
                    xuatVienBenhNhan();
                    break;
                case 3:
                    System.out.println("thoat chuong trinh");
                    return;
                default:
                    System.out.println("lua chon khong hop le");
            }
        }
    }

    private void showMenu() {
        System.out.println("\n==============================");
        System.out.println("he thong xuat vien benh nhan");
        System.out.println("1. xem du lieu hien tai");
        System.out.println("2. xuat vien benh nhan");
        System.out.println("3. thoat");
        System.out.println("==============================");
    }

    private void xuatVienBenhNhan() {
        int patientId = readPositiveInt("nhap ma benh nhan: ");
        double amount = readPositiveDouble("nhap so tien hoa don: ");

        service.xuatVien(patientId, amount);
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
                System.out.println("vui long nhap so hop le");
            }
        }
    }
}
