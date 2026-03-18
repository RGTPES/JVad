package ss8.ex6;


public class KioskFactory implements SalesChannelFactory {
    @Override
    public DiscountStrategy createDiscountStrategy() {
        return new KioskDiscount();
    }

    @Override
    public PaymentMethod createPaymentMethod() {
        return new QRPayment();
    }

    @Override
    public NotificationService createNotificationService() {
        return new SMSNotification();
    }
}
