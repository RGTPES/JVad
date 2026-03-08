package ss1;
import java.util.Scanner;

public class b2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("nhap so nguoi dung: ");
            int totalUsers = scanner.nextInt();
            System.out.print("nhap so nguoi muon chia: ");
            int groups = scanner.nextInt();
            int usersPerGroup = totalUsers / groups;

            System.out.println("moi nhom co: " + usersPerGroup + " nguoi");

        } catch (ArithmeticException e) {
            System.out.println("ko the chia 0");

        } finally {
            scanner.close();
            System.out.println(" finally");
        }
    }
}
