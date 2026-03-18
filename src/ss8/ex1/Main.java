package ss8.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static List<Device> devices = new ArrayList<>();

    public static void main(String[] args) {
        HardwareConnection connection = null;

        while (true) {
            System.out.println("\n===== HE THONG DIEU KHIEN NHA THONG MINH =====");
            System.out.println("1. Ket noi phan cung");
            System.out.println("2. Tao thiet bi moi");
            System.out.println("3. Bat thiet bi");
            System.out.println("4. Tat thiet bi");
            System.out.println("5. Hien thi danh sach thiet bi");
            System.out.println("6. Ngat ket noi phan cung");
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
                    connection = HardwareConnection.getInstance();
                    connection.connect();
                    break;
                case 2:
                    DeviceFactory factory = chooseFactory();
                    if (factory != null) {
                        Device device = factory.createDevice();
                        devices.add(device);
                        System.out.println("Da them thiet bi vao danh sach.");
                    }
                    break;
                case 3:
                    if (devices.isEmpty()) {
                        System.out.println("Chua co thiet bi nao.");
                    } else {
                        showDevices();
                        System.out.print("Chon thiet bi can bat: ");
                        int indexOn = Integer.parseInt(sc.nextLine());
                        if (indexOn >= 1 && indexOn <= devices.size()) {
                            devices.get(indexOn - 1).turnOn();
                        } else {
                            System.out.println("Vi tri khong hop le.");
                        }
                    }
                    break;
                case 4:
                    if (devices.isEmpty()) {
                        System.out.println("Chua co thiet bi nao.");
                    } else {
                        showDevices();
                        System.out.print("Chon thiet bi can tat: ");
                        int indexOff = Integer.parseInt(sc.nextLine());
                        if (indexOff >= 1 && indexOff <= devices.size()) {
                            devices.get(indexOff - 1).turnOff();
                        } else {
                            System.out.println("Vi tri khong hop le.");
                        }
                    }
                    break;
                case 5:
                    showDevices();
                    break;
                case 6:
                    connection = HardwareConnection.getInstance();
                    connection.disconnect();
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh.");
                    return;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        }
    }

    public static DeviceFactory chooseFactory() {
        System.out.println("Chon loai thiet bi:");
        System.out.println("1. Den");
        System.out.println("2. Quat");
        System.out.println("3. Dieu hoa");
        System.out.print("Nhap lua chon: ");

        int type;
        try {
            type = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Lua chon khong hop le.");
            return null;
        }

        switch (type) {
            case 1:
                return new LightFactory();
            case 2:
                return new FanFactory();
            case 3:
                return new AirConditionerFactory();
            default:
                System.out.println("Loai thiet bi khong hop le.");
                return null;
        }
    }

    public static void showDevices() {
        if (devices.isEmpty()) {
            System.out.println("Danh sach thiet bi dang trong.");
            return;
        }

        System.out.println("Danh sach thiet bi:");
        for (int i = 0; i < devices.size(); i++) {
            System.out.println((i + 1) + ". " + devices.get(i).getDeviceName());
        }
    }
}
