package ss9.ex5.persentation;


import ss9.ex5.bussiness.DoctorService;
import ss9.ex5.dao.DoctorDAO;
import ss9.ex5.model.Doctor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Main {
    private static final String DATABASE_NAME = "Hospital_DB";
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Duyanh";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
            DoctorService service = new DoctorService(new DoctorDAO(conn));
            int choice;
            do {
                System.out.println("1. xem danh sach bac si");
                System.out.println("2. them bac si moi");
                System.out.println("3. thong ke");
                System.out.println("4. thoat");
                System.out.print("chon: ");
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        service.showAll();
                        break;
                    case 2:
                        System.out.print("ID: ");
                        String id = sc.nextLine();
                        System.out.print("Full Name: ");
                        String name = sc.nextLine();
                        System.out.print("Chuyen khoa: ");
                        String sp = sc.nextLine();
                        try {
                            service.addDoctor(new Doctor(id, name, sp));
                            System.out.println("them thanh cong");
                        } catch (Exception e) {
                            System.out.println("loi");
                        }
                        break;

                    case 3:
                        service.statistics();
                        break;

                    case 4:
                        System.out.println("thoat chuong trinh");
                        break;

                    default:
                        System.out.println("moi ban nhap lai");
                }
            } while (choice != 4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
