package btth;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Service service = new Service();
        while (true) {
            System.out.println("===== MENU =====");
            System.out.println("1. Update stock");
            System.out.println("2. Find by value");
            System.out.println("3. Total prescription cost");
            System.out.println("4. Revenue by day");
            System.out.println("5. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    System.out.print("Extra quantity: ");
                    int qty = sc.nextInt();
                    service.updateStock(id, qty);
                    break;
                case 2:
                    System.out.print("Min price: ");
                    double min = sc.nextDouble();
                    System.out.print("Max price: ");
                    double max = sc.nextDouble();
                    service.findByPrice(min, max);
                    break;
                case 3:
                    System.out.print("Prescription ID: ");
                    int pid = sc.nextInt();
                    service.getTotal(pid);
                    break;
                case 4:
                    System.out.print("Enter date (yyyy-MM-dd): ");
                    String date = sc.next();
                    service.getRevenue(date);
                    break;
                case 5:
                    return;
            }
        }
    }
}