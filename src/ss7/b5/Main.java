package ss7.b5;

import java.util.*;

class Product {
    private String id;
    private String name;
    private double price;
    private String category;

    public Product(String id, String name, double price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
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

    public String getCategory() {
        return category;
    }
}

class Customer {
    private String name;
    private String email;
    private String phone;

    public Customer(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
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

interface DiscountStrategy {
    double getDiscountAmount(double totalAmount);

    String getName();
}

class PercentageDiscount implements DiscountStrategy {
    private double percent;

    public PercentageDiscount(double percent) {
        this.percent = percent;
    }

    @Override
    public double getDiscountAmount(double totalAmount) {
        return totalAmount * percent / 100;
    }

    @Override
    public String getName() {
        return "Giam " + percent + "%";
    }
}

class FixedDiscount implements DiscountStrategy {
    private double amount;

    public FixedDiscount(double amount) {
        this.amount = amount;
    }

    @Override
    public double getDiscountAmount(double totalAmount) {
        return Math.min(amount, totalAmount);
    }

    @Override
    public String getName() {
        return "Giam co dinh " + (long) amount;
    }
}

class HolidayDiscount implements DiscountStrategy {
    @Override
    public double getDiscountAmount(double totalAmount) {
        return totalAmount * 15 / 100;
    }

    @Override
    public String getName() {
        return "HolidayDiscount 15%";
    }
}

class CustomPercentageDiscount implements DiscountStrategy {
    private String name;
    private double percent;

    public CustomPercentageDiscount(String name, double percent) {
        this.name = name;
        this.percent = percent;
    }

    @Override
    public double getDiscountAmount(double totalAmount) {
        return totalAmount * percent / 100;
    }

    @Override
    public String getName() {
        return name;
    }
}

interface PaymentMethod {
    void pay(double amount);

    String getName();
}

class CODPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Xu ly thanh toan COD: " + formatMoney(amount) + " - Thanh cong");
    }

    @Override
    public String getName() {
        return "COD";
    }

    private String formatMoney(double amount) {
        return String.format("%,.0f", amount);
    }
}

class CreditCardPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Xu ly thanh toan the tin dung: " + formatMoney(amount) + " - Thanh cong");
    }

    @Override
    public String getName() {
        return "The tin dung";
    }

    private String formatMoney(double amount) {
        return String.format("%,.0f", amount);
    }
}

class MomoPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Xu ly thanh toan MoMo: " + formatMoney(amount) + " - Thanh cong");
    }

    @Override
    public String getName() {
        return "MoMo";
    }

    private String formatMoney(double amount) {
        return String.format("%,.0f", amount);
    }
}

class VNPayPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Xu ly thanh toan VNPay: " + formatMoney(amount) + " - Thanh cong");
    }

    @Override
    public String getName() {
        return "VNPay";
    }

    private String formatMoney(double amount) {
        return String.format("%,.0f", amount);
    }
}

class DynamicPaymentMethod implements PaymentMethod {
    private String name;

    public DynamicPaymentMethod(String name) {
        this.name = name;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Xu ly thanh toan " + name + ": " + String.format("%,.0f", amount) + " - Thanh cong");
    }

    @Override
    public String getName() {
        return name;
    }
}

class Order {
    private String orderId;
    private Customer customer;
    private List<OrderItem> items;
    private DiscountStrategy discountStrategy;
    private PaymentMethod paymentMethod;
    private double totalAmount;
    private double discountAmount;
    private double finalAmount;

    public Order(String orderId, Customer customer, List<OrderItem> items,
                 DiscountStrategy discountStrategy, PaymentMethod paymentMethod) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = items;
        this.discountStrategy = discountStrategy;
        this.paymentMethod = paymentMethod;
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

    public DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
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

interface OrderRepository {
    void save(Order order);

    List<Order> findAll();
}

class FileOrderRepository implements OrderRepository {
    private List<Order> orders = new ArrayList<>();

    @Override
    public void save(Order order) {
        orders.add(order);
        System.out.println("Luu don hang vao file: " + order.getOrderId());
    }

    @Override
    public List<Order> findAll() {
        return orders;
    }
}

class DatabaseOrderRepository implements OrderRepository {
    private List<Order> orders = new ArrayList<>();

    @Override
    public void save(Order order) {
        orders.add(order);
        System.out.println("Luu don hang vao database: " + order.getOrderId());
    }

    @Override
    public List<Order> findAll() {
        return orders;
    }
}

interface NotificationService {
    void send(String message, String recipient);

    String getName();
}

class EmailNotification implements NotificationService {
    @Override
    public void send(String message, String recipient) {
        System.out.println("Gui email den " + recipient + ": " + message);
    }

    @Override
    public String getName() {
        return "Email";
    }
}

class SMSNotification implements NotificationService {
    @Override
    public void send(String message, String recipient) {
        System.out.println("Gui SMS den " + recipient + ": " + message);
    }

    @Override
    public String getName() {
        return "SMS";
    }
}

class OrderCalculator {
    public void calculate(Order order) {
        double total = 0;
        for (OrderItem item : order.getItems()) {
            total += item.getSubTotal();
        }
        double discount = order.getDiscountStrategy().getDiscountAmount(total);
        double finalAmount = total - discount;

        order.setTotalAmount(total);
        order.setDiscountAmount(discount);
        order.setFinalAmount(finalAmount);
    }
}

class InvoiceGenerator {
    public void printInvoice(Order order) {
        System.out.println("=== HOA DON ===");
        System.out.println("Khach: " + order.getCustomer().getName());
        for (OrderItem item : order.getItems()) {
            System.out.println(
                    item.getProduct().getId() + " - " + item.getProduct().getName()
                            + " - So luong: " + item.getQuantity()
                            + " - Don gia: " + formatMoney(item.getProduct().getPrice())
                            + " - Thanh tien: " + formatMoney(item.getSubTotal()));
        }
        System.out.println("Tong tien: " + formatMoney(order.getTotalAmount()));
        System.out.println("Giam gia: " + formatMoney(order.getDiscountAmount()));
        System.out.println("Can thanh toan: " + formatMoney(order.getFinalAmount()));
        System.out.println("Phuong thuc thanh toan: " + order.getPaymentMethod().getName());
        System.out.println("Chien luoc giam gia: " + order.getDiscountStrategy().getName());
    }

    private String formatMoney(double amount) {
        return String.format("%,.0f", amount);
    }
}

class OrderService {
    private OrderRepository orderRepository;
    private NotificationService notificationService;
    private OrderCalculator orderCalculator;
    private InvoiceGenerator invoiceGenerator;

    public OrderService(OrderRepository orderRepository,
                        NotificationService notificationService,
                        OrderCalculator orderCalculator,
                        InvoiceGenerator invoiceGenerator) {
        this.orderRepository = orderRepository;
        this.notificationService = notificationService;
        this.orderCalculator = orderCalculator;
        this.invoiceGenerator = invoiceGenerator;
    }

    public void createOrder(Order order) {
        orderCalculator.calculate(order);
        order.getPaymentMethod().pay(order.getFinalAmount());
        invoiceGenerator.printInvoice(order);
        orderRepository.save(order);
        notificationService.send("Don hang " + order.getOrderId() + " da duoc tao", order.getCustomer().getEmail());
        System.out.println("Da luu don hang " + order.getOrderId());
        System.out.println("Da gui " + notificationService.getName() + " xac nhan");
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public double getTotalRevenue() {
        double revenue = 0;
        for (Order order : orderRepository.findAll()) {
            revenue += order.getFinalAmount();
        }
        return revenue;
    }
}

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    private static List<Product> products = new ArrayList<>();
    private static List<Customer> customers = new ArrayList<>();
    private static Map<Integer, DiscountStrategy> discountStrategies = new LinkedHashMap<>();
    private static Map<Integer, PaymentMethod> paymentMethods = new LinkedHashMap<>();

    private static int orderSequence = 1;

    public static void main(String[] args) {
        OrderRepository repository = new FileOrderRepository();
        NotificationService notificationService = new EmailNotification();
        OrderCalculator calculator = new OrderCalculator();
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

        OrderService orderService = new OrderService(repository, notificationService, calculator, invoiceGenerator);

        seedDefaultDiscounts();
        seedDefaultPayments();

        while (true) {
            System.out.println("\n===== MENU QUAN LY DON HANG =====");
            System.out.println("1. Them san pham moi");
            System.out.println("2. Them khach hang moi");
            System.out.println("3. Tao don hang moi");
            System.out.println("4. Xem danh sach don hang");
            System.out.println("5. Tinh tong doanh thu");
            System.out.println("6. Them phuong thuc thanh toan moi");
            System.out.println("7. Them chien luoc giam gia moi");
            System.out.println("8. Thoat");
            System.out.print("Nhap lua chon: ");

            int choice = readInt();

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    addCustomer();
                    break;
                case 3:
                    createOrder(orderService);
                    break;
                case 4:
                    showOrders(orderService);
                    break;
                case 5:
                    showRevenue(orderService);
                    break;
                case 6:
                    addPaymentMethod();
                    break;
                case 7:
                    addDiscountStrategy();
                    break;
                case 8:
                    System.out.println("Thoat chuong trinh");
                    return;
                default:
                    System.out.println("Lua chon khong hop le");
            }
        }
    }

    private static void seedDefaultDiscounts() {
        discountStrategies.put(1, new PercentageDiscount(10));
        discountStrategies.put(2, new FixedDiscount(50000));
        discountStrategies.put(3, new HolidayDiscount());
    }

    private static void seedDefaultPayments() {
        paymentMethods.put(1, new CODPayment());
        paymentMethods.put(2, new CreditCardPayment());
        paymentMethods.put(3, new MomoPayment());
        paymentMethods.put(4, new VNPayPayment());
    }

    private static void addProduct() {
        System.out.print("Nhap ma san pham: ");
        String id = scanner.nextLine();

        System.out.print("Nhap ten san pham: ");
        String name = scanner.nextLine();

        System.out.print("Nhap gia: ");
        double price = readDouble();

        System.out.print("Nhap danh muc: ");
        String category = scanner.nextLine();

        Product product = new Product(id, name, price, category);
        products.add(product);

        System.out.println("Da them san pham " + id);
    }

    private static void addCustomer() {
        System.out.print("Nhap ten khach hang: ");
        String name = scanner.nextLine();

        System.out.print("Nhap email: ");
        String email = scanner.nextLine();

        System.out.print("Nhap so dien thoai: ");
        String phone = scanner.nextLine();

        Customer customer = new Customer(name, email, phone);
        customers.add(customer);

        System.out.println("Da them khach hang");
    }

    private static void createOrder(OrderService orderService) {
        if (products.isEmpty()) {
            System.out.println("Chua co san pham");
            return;
        }

        if (customers.isEmpty()) {
            System.out.println("Chua co khach hang");
            return;
        }

        System.out.println("Chon khach hang:");
        for (int i = 0; i < customers.size(); i++) {
            Customer c = customers.get(i);
            System.out.println((i + 1) + ". " + c.getName() + " - " + c.getEmail());
        }
        System.out.print("Nhap so thu tu khach hang: ");
        int customerIndex = readInt() - 1;

        if (customerIndex < 0 || customerIndex >= customers.size()) {
            System.out.println("Khach hang khong hop le");
            return;
        }

        Customer customer = customers.get(customerIndex);
        List<OrderItem> items = new ArrayList<>();

        while (true) {
            System.out.println("Danh sach san pham:");
            for (int i = 0; i < products.size(); i++) {
                Product p = products.get(i);
                System.out.println((i + 1) + ". " + p.getId() + " - " + p.getName() + " - "
                        + String.format("%,.0f", p.getPrice()));
            }

            System.out.print("Chon san pham: ");
            int productIndex = readInt() - 1;
            if (productIndex < 0 || productIndex >= products.size()) {
                System.out.println("San pham khong hop le");
                return;
            }

            System.out.print("Nhap so luong: ");
            int quantity = readInt();
            items.add(new OrderItem(products.get(productIndex), quantity));

            System.out.print("Them san pham nua khong? (y/n): ");
            String more = scanner.nextLine();
            if (!more.equalsIgnoreCase("y")) {
                break;
            }
        }

        System.out.println("Chon giam gia:");
        for (Map.Entry<Integer, DiscountStrategy> entry : discountStrategies.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue().getName());
        }
        System.out.print("Nhap lua chon giam gia: ");
        int discountChoice = readInt();

        DiscountStrategy discountStrategy = discountStrategies.get(discountChoice);
        if (discountStrategy == null) {
            System.out.println("Lua chon giam gia khong hop le");
            return;
        }

        System.out.println("Chon thanh toan:");
        for (Map.Entry<Integer, PaymentMethod> entry : paymentMethods.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue().getName());
        }
        System.out.print("Nhap lua chon thanh toan: ");
        int paymentChoice = readInt();

        PaymentMethod paymentMethod = paymentMethods.get(paymentChoice);
        if (paymentMethod == null) {
            System.out.println("Lua chon thanh toan khong hop le");
            return;
        }

        String orderId = String.format("ORD%03d", orderSequence++);
        Order order = new Order(orderId, customer, items, discountStrategy, paymentMethod);

        orderService.createOrder(order);
    }

    private static void showOrders(OrderService orderService) {
        List<Order> orders = orderService.findAll();
        if (orders.isEmpty()) {
            System.out.println("Chua co don hang nao");
            return;
        }

        System.out.println("Danh sach don hang:");
        for (Order order : orders) {
            System.out.println(order.getOrderId() + " - " + order.getCustomer().getName() + " - "
                    + String.format("%,.0f", order.getFinalAmount()));
        }
    }

    private static void showRevenue(OrderService orderService) {
        double revenue = orderService.getTotalRevenue();
        System.out.println("Tong doanh thu: " + String.format("%,.0f", revenue));
    }

    private static void addPaymentMethod() {
        System.out.print("Nhap ten phuong thuc thanh toan moi: ");
        String name = scanner.nextLine();

        int nextKey = paymentMethods.size() + 1;
        paymentMethods.put(nextKey, new DynamicPaymentMethod(name));

        System.out.println("Da them phuong thuc thanh toan " + name);
    }

    private static void addDiscountStrategy() {
        System.out.print("Nhap ten chien luoc giam gia moi: ");
        String name = scanner.nextLine();

        System.out.print("Nhap phan tram giam gia: ");
        double percent = readDouble();

        int nextKey = discountStrategies.size() + 1;
        discountStrategies.put(nextKey, new CustomPercentageDiscount(name, percent));

        System.out.println("Da them chien luoc giam gia " + name);
    }

    private static int readInt() {
        while (true) {
            try {
                int value = Integer.parseInt(scanner.nextLine());
                return value;
            } catch (Exception e) {
                System.out.print("Nhap lai so nguyen: ");
            }
        }
    }

    private static double readDouble() {
        while (true) {
            try {
                double value = Double.parseDouble(scanner.nextLine());
                return value;
            } catch (Exception e) {
                System.out.print("Nhap lai so: ");
            }
        }
    }
}
