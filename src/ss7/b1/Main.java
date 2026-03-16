package ss7.b1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private String address;

    public Customer(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
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
}

class Order {
    private String orderId;
    private Customer customer;
    private List<OrderItem> items;
    private double totalAmount;

    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = new ArrayList<>();
        this.totalAmount = 0;
    }

    public void addItem(Product product, int quantity) {
        items.add(new OrderItem(product, quantity));
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

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
class OrderCalculator {
    public double calculateTotal(Order order) {
        double total = 0;
        for (OrderItem item : order.getItems()) {
            total += item.getProduct().getPrice() * item.getQuantity();
        }
        return total;
    }
}
class OrderRepository {
    private Map<String, Order> orderMap = new HashMap<>();

    public void save(Order order) {
        orderMap.put(order.getOrderId(), order);
        System.out.println("Da luu don hang " + order.getOrderId());
    }

    public Order findById(String orderId) {
        return orderMap.get(orderId);
    }
}
class EmailService {
    public void sendOrderConfirmation(Order order) {
        System.out.println("Da gui email den " + order.getCustomer().getEmail()
                + ": Don hang " + order.getOrderId() + " da duoc tao");
    }
}
public class Main {
    public static void main(String[] args) {
        Product p1 = new Product("SP01", "Laptop", 15000000);
        Product p2 = new Product("SP02", "Chuot", 300000);
        System.out.println("Da them san pham SP01, SP02");

        Customer customer = new Customer("Nguyen Van A", "a@example.com", "Ha Noi");
        System.out.println("Da them khach hang");

        Order order = new Order("ORD001", customer);
        order.addItem(p1, 1);
        order.addItem(p2, 2);
        System.out.println("Don hang ORD001 duoc tao");

        OrderCalculator calculator = new OrderCalculator();
        double total = calculator.calculateTotal(order);
        order.setTotalAmount(total);
        System.out.println("Tong tien: " + (long) total);

        OrderRepository repository = new OrderRepository();
        repository.save(order);

        EmailService emailService = new EmailService();
        emailService.sendOrderConfirmation(order);
    }
}

