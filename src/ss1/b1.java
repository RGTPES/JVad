package ss1;
import java.util.Scanner;

public class b1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("nhap 1 so: ");
            String input = scanner.nextLine();

            int number = Integer.parseInt(input);

            System.out.println("ban da nhap so : " + number);

        } catch (NumberFormatException e) {
            System.out.println("ban phai nhap so");

        } finally {
            scanner.close();
            System.out.println("finally");
        }
    }
}