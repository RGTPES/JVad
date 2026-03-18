package ss8.ex6;

public class EmailNotification implements NotificationService {
    @Override
    public void notifyCustomer(String message) {
        System.out.println("Gửi email: " + message);
    }
}
