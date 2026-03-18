package ss8.ex6;



public class MemberDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(double amount) {
        return amount * 0.05;
    }

    @Override
    public String getDescription() {
        return "giảm giá 5% cho thành viên";
    }
}