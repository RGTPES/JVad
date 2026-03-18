package ss8.ex6;


public class OrderService {
    private DiscountStrategy discountStrategy;
    private PaymentMethod paymentMethod;
    private NotificationService notificationService;

    public OrderService(SalesChannelFactory factory) {
        this.discountStrategy = factory.createDiscountStrategy();
        this.paymentMethod = factory.createPaymentMethod();
        this.notificationService = factory.createNotificationService();
    }

    public void processOrder(Order order) {
        double total = order.getTotalAmount();
        double discount = discountStrategy.calculateDiscount(total);
        double finalAmount = total - discount;

        System.out.println("Sản phẩm: " + order.getProductName());
        System.out.printf("Đơn giá: %,.0f%n", order.getUnitPrice());
        System.out.println("Số lượng: " + order.getQuantity());
        System.out.printf("Tổng tiền: %,.0f%n", total);
        System.out.printf("Áp dụng %s: %,.0f%n", discountStrategy.getDescription(), discount);

        paymentMethod.pay(finalAmount);
        notificationService.notifyCustomer("Đơn hàng thành công");
    }
}
