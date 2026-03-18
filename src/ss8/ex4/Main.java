package ss8.ex4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TemperatureSensor sensor = new TemperatureSensor();
        Fan fan = new Fan();
        Humidifier humidifier = new Humidifier();

        boolean fanRegistered = false;
        boolean humidifierRegistered = false;

        while (true) {
            System.out.println("\n===== HỆ THỐNG NHÀ THÔNG MINH =====");
            System.out.println("1. Đăng ký Quạt");
            System.out.println("2. Đăng ký Máy tạo ẩm");
            System.out.println("3. Nhập nhiệt độ");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (!fanRegistered) {
                        sensor.attach(fan);
                        fanRegistered = true;
                    } else {
                        System.out.println("Quạt đã đăng ký rồi!");
                    }
                    break;

                case 2:
                    if (!humidifierRegistered) {
                        sensor.attach(humidifier);
                        humidifierRegistered = true;
                    } else {
                        System.out.println("Máy tạo ẩm đã đăng ký rồi!");
                    }
                    break;

                case 3:
                    System.out.print("Nhập nhiệt độ: ");
                    int temp = scanner.nextInt();
                    sensor.setTemperature(temp);
                    break;

                case 0:
                    System.out.println("Thoát chương trình...");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
