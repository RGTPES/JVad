package ss8.ex6;



public class KioskDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(double amount) {
        return amount * 0.07;
    }

    @Override
    public String getDescription() {
        return "giảm giá 7% tại kiosk";
    }
}
