package ss8.ex2;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Light light = new Light();
        Fan fan = new Fan();
        AirConditioner airConditioner = new AirConditioner();

        OldThermometer oldThermometer = new OldThermometer();
        TemperatureSensor sensor = new ThermometerAdapter(oldThermometer);

        SmartHomeFacade facade = new SmartHomeFacade(light, fan, airConditioner, sensor);

        while (true) {
            System.out.println("\n===== HE THONG NHA THONG MINH =====");
            System.out.println("1. Xem nhiet do hien tai");
            System.out.println("2. Kich hoat che do roi nha");
            System.out.println("3. Kich hoat che do ngu");
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
                    facade.getCurrentTemperature();
                    break;
                case 2:
                    facade.leaveHome();
                    break;
                case 3:
                    facade.sleepMode();
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh.");
                    return;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        }
    }
}
