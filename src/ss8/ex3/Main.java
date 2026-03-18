package ss8.ex3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Light light = new Light();
        Fan fan = new Fan();
        AirConditioner airConditioner = new AirConditioner();
        RemoteControl remote = new RemoteControl();

        while (true) {
            System.out.println("\n===== REMOTE DIEU KHIEN NHA THONG MINH =====");
            System.out.println("1. Gan command cho nut");
            System.out.println("2. Nhan nut");
            System.out.println("3. Undo lenh vua thuc hien");
            System.out.println("4. Xem danh sach nut da gan");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Lua chon khong hop le.");
                continue;
            }

            switch (choice) {
                case 1:
                    assignCommand(sc, remote, light, fan, airConditioner);
                    break;
                case 2:
                    System.out.print("Nhap so nut muon nhan: ");
                    try {
                        int button = Integer.parseInt(sc.nextLine());
                        remote.pressButton(button);
                    } catch (Exception e) {
                        System.out.println("So nut khong hop le.");
                    }
                    break;
                case 3:
                    remote.undoLastCommand();
                    break;
                case 4:
                    remote.showAssignedButtons();
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh.");
                    return;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        }
    }

    public static void assignCommand(Scanner sc, RemoteControl remote, Light light, Fan fan, AirConditioner airConditioner) {
        try {
            System.out.print("Nhap so nut can gan: ");
            int button = Integer.parseInt(sc.nextLine());

            System.out.println("Chon lenh:");
            System.out.println("1. Bat den");
            System.out.println("2. Tat den");
            System.out.println("3. Bat quat");
            System.out.println("4. Tat quat");
            System.out.println("5. Set nhiet do dieu hoa");
            System.out.print("Nhap lua chon: ");

            int option = Integer.parseInt(sc.nextLine());
            Command command = null;

            switch (option) {
                case 1:
                    command = new LightOnCommand(light);
                    break;
                case 2:
                    command = new LightOffCommand(light);
                    break;
                case 3:
                    command = new FanOnCommand(fan);
                    break;
                case 4:
                    command = new FanOffCommand(fan);
                    break;
                case 5:
                    System.out.print("Nhap nhiet do can dat: ");
                    int temp = Integer.parseInt(sc.nextLine());
                    command = new ACSetTemperatureCommand(airConditioner, temp);
                    break;
                default:
                    System.out.println("Lenh khong hop le.");
                    return;
            }

            remote.setCommand(button, command);
        } catch (Exception e) {
            System.out.println("Du lieu nhap khong hop le.");
        }
    }
}
