package ss6.b4;

public class Main {
    public static void main(String[] args) throws Exception {

        TicketPool roomA = new TicketPool("A", 10);
        TicketPool roomB = new TicketPool("B", 10);

        BookingCounter c1 = new BookingCounter("Quầy 1", roomA, roomB);
        BookingCounter c2 = new BookingCounter("Quầy 2", roomA, roomB);

        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Kết thúc chương trình");
        System.out.println("Quầy 1 bán: " + c1.getSoldCount());
        System.out.println("Quầy 2 bán: " + c2.getSoldCount());
        System.out.println("Vé còn phòng A: " + roomA.remainingTickets());
        System.out.println("Vé còn phòng B: " + roomB.remainingTickets());
    }
}
