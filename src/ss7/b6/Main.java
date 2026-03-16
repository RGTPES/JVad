package ss7.b6;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private String id;
    private String name;
    private double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Customer {
    private String name;
    private String email;
    private String phone;
    private boolean firstPurchase;
    private boolean member;

    public Customer(String name, String email, String phone, boolean firstPurchase, boolean member) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.firstPurchase = firstPurchase;
        this.member = member;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public boolean isFirstPurchase() {
        return firstPurchase;
    }

    public boolean isMember() {
        return member;
    }

    public void setFirstPurchase(boolean firstPurchase) {
        this.firstPurchase = firstPurchase;
    }
}

class OrderItem {
    private Product product;
    private int quantity;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSubTotal() {
        return product.getPrice() * quantity;
    }
}

class Order {
    private String orderId;
    private Customer customer;
    private List<OrderItem> items;
    private double totalAmount;
    private double discountAmount;
    private double finalAmount;

    public Order(String orderId, Customer customer, List<OrderItem> items) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = items;
    }

    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public void setFinalAmount(double finalAmount) {
        this.finalAmount = finalAmount;
    }
}

interface DiscountStrategy {
    double getDiscountAmount(Order order);
    String getDescription();
}

interface PaymentMethod {
    void pay(double amount);
    String getName();
}

interface NotificationService {
    void send(Order order);
    String getName();
}

interface SalesChannelFactory {
    DiscountStrategy createDiscountStrategy();
    PaymentMethod createPaymentMethod();
    NotificationService createNotificationService();
    String getChannelName();
}

class WebsiteDiscount implements DiscountStrategy {
    private String couponCode;

    public WebsiteDiscount(String couponCode) {
        this.couponCode = couponCode;
    }

    @Override
    public double getDiscountAmount(Order order) {
        if ("WEB10".equalsIgnoreCase(couponCode)) {
            System.out.println("Ap dung giam gia 10% cho don hang website");
            return order.getTotalAmount() * 10 / 100;
        }
        System.out.println("Khong ap dung ma giam gia website");
        return 0;
    }

    @Override
    public String getDescription() {
        return "Website coupon";
    }
}

class MobileAppDiscount implements DiscountStrategy {
    @Override
    public double getDiscountAmount(Order order) {
        if (order.getCustomer().isFirstPurchase()) {
            System.out.println("Ap dung giam gia 15% cho lan dau");
            return order.getTotalAmount() * 15 / 100;
        }
        System.out.println("Khong co giam gia mobile app");
        return 0;
    }

    @Override
    public String getDescription() {
        return "Mobile first purchase";
    }
}

class StorePOSDiscount implements DiscountStrategy {
    @Override
    public double getDiscountAmount(Order order) {
        if (order.getCustomer().isMember()) {
            System.out.println("Ap dung giam gia 5% cho thanh vien tai POS");
            return order.getTotalAmount() * 5 / 100;
        }
        System.out.println("Khong co giam gia POS");
        return 0;
    }

    @Override
    public String getDescription() {
        return "POS membership";
    }
}

class CreditCardOnlinePayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Xu ly thanh toan the tin dung qua cong thanh toan online");
        System.out.println("So tien thanh toan: " + String.format("%,.0f", amount));
    }

    @Override
    public String getName() {
        return "The tin dung";
    }
}

class MomoIntegratedPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Xu ly thanh toan MoMo tich hop");
        System.out.println("So tien thanh toan: " + String.format("%,.0f", amount));
    }

    @Override
    public String getName() {
        return "MoMo";
    }
}

class CashPOSPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Xu ly thanh toan tai quay POS");
        System.out.println("So tien thanh toan: " + String.format("%,.0f", amount));
    }

    @Override
    public String getName() {
        return "Tien mat/POS";
    }
}

class EmailNotification implements NotificationService {
    @Override
    public void send(Order order) {
        System.out.println("Gui email xac nhan den " + order.getCustomer().getEmail());
    }

    @Override
    public String getName() {
        return "Email";
    }
}

class PushNotification implements NotificationService {
    @Override
    public void send(Order order) {
        System.out.println("Gui push notification: Don hang thanh cong");
    }

    @Override
    public String getName() {
        return "Push Notification";
    }
}

class PaperInvoiceNotification implements NotificationService {
    @Override
    public void send(Order order) {
        System.out.println("In hoa don giay tai cua hang");
    }

    @Override
    public String getName() {
        return "Paper Invoice";
    }
}

class WebsiteFactory implements SalesChannelFactory {
    private String couponCode;

    public WebsiteFactory(String couponCode) {
        this.couponCode = couponCode;
    }

    @Override
    public DiscountStrategy createDiscountStrategy() {
        return new WebsiteDiscount(couponCode);
    }

    @Override
    public PaymentMethod createPaymentMethod() {
        return new CreditCardOnlinePayment();
    }

    @Override
    public NotificationService createNotificationService() {
        return new EmailNotification();
    }

    @Override
    public String getChannelName() {
        return "Website";
    }
}

class MobileAppFactory implements SalesChannelFactory {
    @Override
    public DiscountStrategy createDiscountStrategy() {
        return new MobileAppDiscount();
    }

    @Override
    public PaymentMethod createPaymentMethod() {
        return new MomoIntegratedPayment();
    }

    @Override
    public NotificationService createNotificationService() {
        return new PushNotification();
    }

    @Override
    public String getChannelName() {
        return "Mobile App";
    }
}

class StorePOSFactory implements SalesChannelFactory {
    @Override
    public DiscountStrategy createDiscountStrategy() {
        return new StorePOSDiscount();
    }

    @Override
    public PaymentMethod createPaymentMethod() {
        return new CashPOSPayment();
    }

    @Override
    public NotificationService createNotificationService() {
        return new PaperInvoiceNotification();
    }

    @Override
    public String getChannelName() {
        return "Store POS";
    }
}

class KioskDiscount implements DiscountStrategy {
    @Override
    public double getDiscountAmount(Order order) {
        System.out.println("Ap dung giam gia 8% cho Kiosk tu dong");
        return order.getTotalAmount() * 8 / 100;
    }

    @Override
    public String getDescription() {
        return "Kiosk 8%";
    }
}

class KioskQRPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Xu ly thanh toan QR tai Kiosk");
        System.out.println("So tien thanh toan: " + String.format("%,.0f", amount));
    }

    @Override
    public String getName() {
        return "QR Kiosk";
    }
}

class KioskScreenNotification implements NotificationService {
    @Override
    public void send(Order order) {
        System.out.println("Hien thi thong bao tren man hinh Kiosk: Don hang thanh cong");
    }

    @Override
    public String getName() {
        return "Kiosk Screen";
    }
}

class KioskFactory implements SalesChannelFactory {
    @Override
    public DiscountStrategy createDiscountStrategy() {
        return new KioskDiscount();
    }

    @Override
    public PaymentMethod createPaymentMethod() {
        return new KioskQRPayment();
    }

    @Override
    public NotificationService createNotificationService() {
        return new KioskScreenNotification();
    }

    @Override
    public String getChannelName() {
        return "Kiosk tu dong";
    }
}

class OrderCalculator {
    public void calculate(Order order, DiscountStrategy discountStrategy) {
        double total = 0;
        for (OrderItem item : order.getItems()) {
            total += item.getSubTotal();
        }
        order.setTotalAmount(total);

        double discount = discountStrategy.getDiscountAmount(order);
        order.setDiscountAmount(discount);
        order.setFinalAmount(total - discount);
    }
}

class InvoiceGenerator {
    public void printInvoice(Order order, String channelName, PaymentMethod paymentMethod) {
        System.out.println("\n=== HOA DON ===");
        System.out.println("Ma don: " + order.getOrderId());
        System.out.println("Kenh ban: " + channelName);
        System.out.println("Khach: " + order.getCustomer().getName());

        for (OrderItem item : order.getItems()) {
            System.out.println(
                    item.getProduct().getName()
                            + " - So luong: " + item.getQuantity()
                            + " - Don gia: " + String.format("%,.0f", item.getProduct().getPrice())
                            + " - Thanh tien: " + String.format("%,.0f", item.getSubTotal())
            );
        }

        System.out.println("Tong tien: " + String.format("%,.0f", order.getTotalAmount()));
        System.out.println("Giam gia: " + String.format("%,.0f", order.getDiscountAmount()));
        System.out.println("Can thanh toan: " + String.format("%,.0f", order.getFinalAmount()));
        System.out.println("Thanh toan: " + paymentMethod.getName());
    }
}

class OrderService {
    private OrderCalculator orderCalculator;
    private InvoiceGenerator invoiceGenerator;

    public OrderService(OrderCalculator orderCalculator, InvoiceGenerator invoiceGenerator) {
        this.orderCalculator = orderCalculator;
        this.invoiceGenerator = invoiceGenerator;
    }

    public void processOrder(Order order, SalesChannelFactory factory) {
        DiscountStrategy discountStrategy = factory.createDiscountStrategy();
        PaymentMethod paymentMethod = factory.createPaymentMethod();
        NotificationService notificationService = factory.createNotificationService();

        orderCalculator.calculate(order, discountStrategy);
        paymentMethod.pay(order.getFinalAmount());
        invoiceGenerator.printInvoice(order, factory.getChannelName(), paymentMethod);
        notificationService.send(order);
    }
}

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Product> products = new ArrayList<>();
    private static List<Customer> customers = new ArrayList<>();
    private static int orderSequence = 1;
    private static boolean kioskAdded = false;

    public static void main(String[] args) {
        seedData();
        OrderService orderService = new OrderService(new OrderCalculator(), new InvoiceGenerator());

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Tao don hang theo kenh ban");
            System.out.println("2. Them kenh moi (mo phong Kiosk)");
            System.out.println("3. Thoat");
            System.out.print("Nhap lua chon: ");

            int choice = readInt();

            if (choice == 1) {
                SalesChannelFactory factory = chooseChannelFactory();
                if (factory != null) {
                    System.out.println("Ban da chon kenh " + factory.getChannelName());
                    Order order = createOrder();
                    if (order != null) {
                        orderService.processOrder(order, factory);
                        order.getCustomer().setFirstPurchase(false);
                    }
                }
            } else if (choice == 2) {
                kioskAdded = true;
                System.out.println("Da them kenh moi: Kiosk tu dong");
                System.out.println("Chi can tao factory moi, khong sua code cu");
            } else if (choice == 3) {
                System.out.println("Thoat chuong trinh");
                break;
            } else {
                System.out.println("Lua chon khong hop le");
            }
        }
    }

    private static SalesChannelFactory chooseChannelFactory() {
        System.out.println("Chon kenh ban:");
        System.out.println("1. Website");
        System.out.println("2. Mobile App");
        System.out.println("3. POS");
        if (kioskAdded) {
            System.out.println("4. Kiosk tu dong");
        }
        System.out.print("Nhap lua chon: ");

        int choice = readInt();

        switch (choice) {
            case 1:
                System.out.print("Nhap ma giam gia website: ");
                String coupon = scanner.nextLine();
                return new WebsiteFactory(coupon);
            case 2:
                return new MobileAppFactory();
            case 3:
                return new StorePOSFactory();
            case 4:
                if (kioskAdded) {
                    return new KioskFactory();
                }
                System.out.println("Kenh khong hop le");
                return null;
            default:
                System.out.println("Kenh khong hop le");
                return null;
        }
    }

    private static Order createOrder() {
        if (customers.isEmpty() || products.isEmpty()) {
            System.out.println("Chua co du lieu khach hang hoac san pham");
            return null;
        }

        System.out.println("Chon khach hang:");
        for (int i = 0; i < customers.size(); i++) {
            System.out.println((i + 1) + ". " + customers.get(i).getName());
        }
        System.out.print("Nhap lua chon: ");
        int customerIndex = readInt() - 1;

        if (customerIndex < 0 || customerIndex >= customers.size()) {
            System.out.println("Khach hang khong hop le");
            return null;
        }

        Customer customer = customers.get(customerIndex);
        List<OrderItem> items = new ArrayList<>();

        while (true) {
            System.out.println("Chon san pham:");
            for (int i = 0; i < products.size(); i++) {
                Product p = products.get(i);
                System.out.println((i + 1) + ". " + p.getName() + " - " + String.format("%,.0f", p.getPrice()));
            }

            System.out.print("Nhap lua chon san pham: ");
            int productIndex = readInt() - 1;

            if (productIndex < 0 || productIndex >= products.size()) {
                System.out.println("San pham khong hop le");
                return null;
            }

            System.out.print("Nhap so luong: ");
            int quantity = readInt();

            if (quantity <= 0) {
                System.out.println("So luong phai lon hon 0");
                return null;
            }

            items.add(new OrderItem(products.get(productIndex), quantity));

            System.out.print("Them san pham nua khong? (y/n): ");
            String ans = scanner.nextLine();
            if (!ans.equalsIgnoreCase("y")) {
                break;
            }
        }

        String orderId = String.format("ORD%03d", orderSequence++);
        return new Order(orderId, customer, items);
    }

    private static void seedData() {
        products.add(new Product("SP01", "Laptop", 15000000));
        products.add(new Product("SP02", "Dien thoai", 12000000));
        products.add(new Product("SP03", "Chuot", 300000));

        customers.add(new Customer("Nguyen Van A", "a@example.com", "0123456789", true, true));
        customers.add(new Customer("Tran Thi B", "b@example.com", "0988888888", false, false));
    }

    private static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.print("Nhap lai so nguyen: ");
            }
        }
    }
}