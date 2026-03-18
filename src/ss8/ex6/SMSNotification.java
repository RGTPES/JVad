package ss8.ex6;


public class SMSNotification implements NotificationService {
    @Override
    public void notifyCustomer(String message) {
        System.out.println("Gửi SMS: " + message);
    }
}
