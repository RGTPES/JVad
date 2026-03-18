package ss8.ex6;


public interface DiscountStrategy {
    double calculateDiscount(double amount);
    String getDescription();
}
