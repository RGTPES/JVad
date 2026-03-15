package ss6.b1;

public class Main {
    public static void main(String[] args) {

        TicketPool roomA = new TicketPool("A", 2);
        TicketPool roomB = new TicketPool("B", 2);

        BookingCounter counter1 = new BookingCounter("Quay 1", roomA, roomB);
        BookingCounter counter2 = new BookingCounter("Quay 2", roomA, roomB);

        Thread t1 = new Thread(counter1);
        Thread t2 = new Thread(counter2);

        t1.start();
        t2.start();
    }
}