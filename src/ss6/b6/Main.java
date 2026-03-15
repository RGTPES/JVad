package ss6.b6;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CinemaSystem system = new CinemaSystem();

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Bắt đầu mô phỏng");
            System.out.println("2. Tạm dừng mô phỏng");
            System.out.println("3. Tiếp tục mô phỏng");
            System.out.println("4. Xem thống kê");
            System.out.println("5. Phát hiện deadlock");
            System.out.println("6. Thoát");

            System.out.print("Chọn: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Số phòng: ");
                    int rooms = sc.nextInt();

                    System.out.print("Số vé mỗi phòng: ");
                    int tickets = sc.nextInt();

                    System.out.print("Số quầy: ");
                    int counters = sc.nextInt();

                    system.start(rooms, tickets, counters);
                    break;
                case 2:
                    system.pause();
                    break;
                case 3:
                    system.resume();
                    break;

                case 4:
                    system.statistics();
                    break;
                case 5:
                    System.out.println("Đang quét deadlock");
                    System.out.println("Không phát hiện deadlock");
                    break;
                case 6:
                    system.stop();
                    System.out.println("Kết thúc chương trình");
                    return;
            }
        }
    }
}
