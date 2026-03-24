package ex5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== RHMS MENU =====");
            System.out.println("1. Patiens List");
            System.out.println("2. Add Patiens");
            System.out.println("3. Update medical records");
            System.out.println("4. Discharge and billing");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    service.showPatients();
                    break;

                case 2:
                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Age: ");
                    int age = sc.nextInt(); sc.nextLine();

                    System.out.print("Department: ");
                    String dep = sc.nextLine();

                    System.out.print("Disease: ");
                    String dis = sc.nextLine();

                    service.addPatient(name, age, dep, dis);
                    break;

                case 3:
                    System.out.print("ID: ");
                    int idUpdate = sc.nextInt(); sc.nextLine();

                    System.out.print("New disease: ");
                    String newDis = sc.nextLine();

                    service.updateDisease(idUpdate, newDis);
                    break;

                case 4:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    double fee = service.dischargePatient(id);
                    System.out.println("Total fee: " + fee);
                    break;
                case 5:
                    System.out.println("Bye!");
                    return;
                default:
                    System.out.println("Choose not valid!");
            }
        }
    }
}
