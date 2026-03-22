package ss9.ex6;


import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AppointmentRepository repo = new AppointmentRepository();
        int choice;
        do {
            System.out.println("1. Them lich");
            System.out.println("2. xem tat ca");
            System.out.println("3. sua");
            System.out.println("4. xoa");
            System.out.println("5. thoat");
            System.out.print("Chọn: ");
            choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {

                    case 1:
                        System.out.print("ten: ");
                        String name = sc.nextLine();

                        System.out.print("ngay (yyyy-mm-dd): ");
                        Date date = Date.valueOf(sc.nextLine());

                        System.out.print("bac si: ");
                        String doctor = sc.nextLine();

                        System.out.print("trang thai: ");
                        String status = sc.nextLine();

                        repo.add(new Appointment(name, date, doctor, status));
                        System.out.println("them thanh cong");
                        break;

                    case 2:
                        List<Appointment> list = repo.getAll();
                        for (Appointment a : list) {
                            System.out.println(
                                    a.getId() + " | " +
                                            a.getPatientName() + " | " +
                                            a.getAppointmentDate() + " | " +
                                            a.getDoctorName() + " | " +
                                            a.getStatus()
                            );
                        }
                        break;

                    case 3:
                        System.out.print("Nhap id sua: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("ten moi ");
                        String n = sc.nextLine();

                        System.out.print("ngay moi: ");
                        Date d = Date.valueOf(sc.nextLine());

                        System.out.print("bac si moi: ");
                        String doc = sc.nextLine();

                        System.out.print("trang thai: ");
                        String st = sc.nextLine();

                        repo.update(new Appointment(id, n, d, doc, st));
                        System.out.println("cap nhat thanh cong");
                        break;

                    case 4:
                        System.out.print("Nhap id: ");
                        int delId = sc.nextInt();
                        repo.delete(delId);
                        System.out.println("xoa thanh conmg");
                        break;
                    case 5:
                        System.out.println("thoat chuong trinh");
                        break;
                    default:
                        System.out.println("moi ban nhap lai");
                }

            } catch (Exception e) {
                System.out.println("loi");
            }

        } while (choice != 5);
    }
}
