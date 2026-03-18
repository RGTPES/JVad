package ss8.ex6;


import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== HỆ THỐNG BÁN HÀNG ĐA KÊNH =====");
            System.out.println("1. Website");
            System.out.println("2. Mobile App");
            System.out.println("3. POS tại cửa hàng");
            System.out.println("4. Kiosk");
            System.out.println("0. Thoát");
            System.out.print("Chọn kênh bán hàng: ");

            int choice = readInt();

            if (choice == 0) {
                System.out.println("Thoát chương trình.");
                break;
            }

            SalesChannelFactory factory = createFactory(choice);

            if (factory == null) {
                System.out.println("Lựa chọn không hợp lệ.");
                continue;
            }

            showChannelName(choice);

            Order order = inputOrder();
            OrderService orderService = new OrderService(factory);
            System.out.println("\n----- XỬ LÝ ĐƠN HÀNG -----");
            orderService.processOrder(order);
        }
    }

    private static SalesChannelFactory createFactory(int choice) {
        switch (choice) {
            case 1:
                return new WebsiteFactory();
            case 2:
                return new MobileAppFactory();
            case 3:
                return new POSFactory();
            case 4:
                return new KioskFactory();
            default:
                return null;
        }
    }

    private static void showChannelName(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Bạn đã chọn kênh Website");
                break;
            case 2:
                System.out.println("Bạn đã chọn kênh Mobile App");
                break;
            case 3:
                System.out.println("Bạn đã chọn kênh POS");
                break;
            case 4:
                System.out.println("Bạn đã chọn kênh Kiosk");
                break;
        }
    }

    private static Order inputOrder() {
        System.out.println("\n----- NHẬP THÔNG TIN ĐƠN HÀNG -----");
        System.out.print("Tên sản phẩm: ");
        String productName = scanner.nextLine();

        System.out.print("Đơn giá: ");
        double unitPrice = readDouble();

        System.out.print("Số lượng: ");
        int quantity = readInt();

        return new Order(productName, unitPrice, quantity);
    }

    private static int readInt() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (Exception e) {
                System.out.print("Vui lòng nhập số nguyên hợp lệ: ");
            }
        }
    }

    private static double readDouble() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Double.parseDouble(input);
            } catch (Exception e) {
                System.out.print("Vui lòng nhập số hợp lệ: ");
            }
        }
    }
}
