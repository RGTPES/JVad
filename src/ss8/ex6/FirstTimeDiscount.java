package ss8.ex6;

public class FirstTimeDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(double amount) {
        return amount * 0.15;
    }

    @Override
    public String getDescription() {
        return "giảm giá 15% (lần đầu)";
    }
}
