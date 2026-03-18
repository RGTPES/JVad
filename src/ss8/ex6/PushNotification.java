package ss8.ex6;


public class PushNotification implements NotificationService {
    @Override
    public void notifyCustomer(String message) {
        System.out.println("Gửi push notification: " + message);
    }
}
