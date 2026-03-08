package ss1;
import java.util.Scanner;
class InvalidAgeException extends Exception {
    public InvalidAgeException(String msg) {
        super(msg);
    }
}
class User {
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Tuoi khong the am!");
        }
        this.age = age;
    }
    public int getAge() {
        return age;
    }
}
public class b5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User user = new User();
        System.out.print("nhap tuoi: ");
        int age = sc.nextInt();
        try {
            user.setAge(age);
            System.out.println("tuoi hop le: " + user.getAge());
        } catch (InvalidAgeException e) {
            System.out.println("loi: " + e.getMessage());
        }
        sc.close();
    }
}
