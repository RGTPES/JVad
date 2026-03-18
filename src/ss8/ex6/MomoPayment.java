package ss8.ex6;


public class MomoPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.printf("Xử lý thanh toán MoMo: %,.0f%n", amount);
    }
}
