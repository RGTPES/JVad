package ss7.b4;

import java.util.ArrayList;
import java.util.List;

class Order {
    private String orderId;

    public Order(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }
}

interface OrderRepository {
    public void save(Order order);

    List<Order> findAll();
}

interface NotificationService {
    public void send(String message, String recipient);
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

class EmailService implements NotificationService {
    @Override
    public void send(String message, String recipient) {
        System.out.println("Gui email: " + message);
    }
}

class SMSNotification implements NotificationService {
    @Override
    public void send(String message, String recipient) {
        System.out.println("Gui SMS: " + message);
    }
}

class OrderService {
    private OrderRepository orderRepository;
    private NotificationService notificationService;

    public OrderService(OrderRepository orderRepository, NotificationService notificationService) {
        this.orderRepository = orderRepository;
        this.notificationService = notificationService;
    }

    public void createOrder(Order order, String recipient) {
        orderRepository.save(order);
        notificationService.send("Don hang " + order.getOrderId() + " da duoc tao", recipient);
    }
}

public class Main {
    public static void main(String[] args) {
        OrderRepository fileRepository = new FileOrderRepository();
        NotificationService emailService = new EmailService();

        OrderService orderService1 = new OrderService(fileRepository, emailService);
        Order order1 = new Order("ORD001");
        orderService1.createOrder(order1, "a@example.com");

        System.out.println();

        OrderRepository databaseRepository = new DatabaseOrderRepository();
        NotificationService smsNotification = new SMSNotification();

        OrderService orderService2 = new OrderService(databaseRepository, smsNotification);
        Order order2 = new Order("ORD002");
        orderService2.createOrder(order2, "0123456789");
    }
}
