package ss1;
import java.io.IOException;
public class b4 {
    public static void saveToFile() throws IOException {
        throw new IOException("Loi ko the day file");
    }
    public static void processUserData() throws IOException {
        saveToFile();
    }
    public static void main(String[] args) {
        try {
            processUserData();
            System.out.println("thanh cong");
        } catch (IOException e) {
            System.out.println("xay ra loi: " + e.getMessage());
        }

    }
}
