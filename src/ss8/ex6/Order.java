package ss8.ex6;

public class Order {
    private String productName;
    private double unitPrice;
    private int quantity;

    public Order(String productName, double unitPrice, int quantity) {
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalAmount() {
        return unitPrice * quantity;
    }
}
