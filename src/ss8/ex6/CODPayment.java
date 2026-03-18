package ss8.ex6;



public class CODPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.printf("Xử lý thanh toán COD: %,.0f%n", amount);
    }
}