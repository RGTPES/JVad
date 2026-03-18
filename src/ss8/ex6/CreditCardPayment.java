package ss8.ex6;

public class CreditCardPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.printf("Xử lý thanh toán thẻ tín dụng: %,.0f%n", amount);
    }
}
