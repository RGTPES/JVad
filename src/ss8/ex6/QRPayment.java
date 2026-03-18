package ss8.ex6;


public class QRPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.printf("Xử lý thanh toán QR: %,.0f%n", amount);
    }
}
