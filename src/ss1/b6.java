package ss1;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
class LoggerUtil {
    public static void logError(String message, Exception e) {
        String time = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("[ERROR] " + time + " - " + message);
        System.out.println("[ERROR] Chi tiet: " + e.getClass().getSimpleName() + " - " + e.getMessage());
    }
}
class UserFileService {
    public static void saveToFile(User user) throws IOException {
        throw new IOException("Khong the ghi du lieu nguoi dung vao file");
    }
    public static void processUserData(User user) throws IOException {
        saveToFile(user);
    }
}
public class b6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            User user = new User();
            System.out.print("Nhap ten nguoi dung: ");
            String name = sc.nextLine();
            user.setName(name);
            System.out.print("Nhap tuoi: ");
            int age = Integer.parseInt(sc.nextLine());
            user.setAge(age);
            System.out.print("Nhap tong so nguoi dung: ");
            int total = Integer.parseInt(sc.nextLine());
            System.out.print("Nhap so nhom muon chia: ");
            int groups = Integer.parseInt(sc.nextLine());
            int usersPerGroup = total / groups;
            System.out.println("Moi nhom co: " + usersPerGroup + " nguoi");
            if (user.getName() != null) {
                System.out.println("Ten nguoi dung: " + user.getName().toUpperCase());
            } else {
                System.out.println("Ten nguoi dung dang trong");
            }

            try {
                UserFileService.processUserData(user);
                System.out.println("Luu file thanh cong");
            } catch (IOException e) {
                LoggerUtil.logError("Loi khi luu thong tin nguoi dung ra file", e);
            }

        } catch (InvalidAgeException e) {
            LoggerUtil.logError("Du lieu tuoi khong hop le", e);

        } catch (NumberFormatException e) {
            LoggerUtil.logError("Nguoi dung nhap sai dinh dang so", e);

        } catch (ArithmeticException e) {
            LoggerUtil.logError("Khong the chia cho 0 khi chia nhom", e);

        } finally {
            sc.close();
            System.out.println("finally");
        }
    }
}