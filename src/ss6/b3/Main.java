package ss6.b3;

public class Main {

    public static void main(String[] args) {

        TicketPool roomA = new TicketPool("A", 10);
        TicketPool roomB = new TicketPool("B", 10);

        TicketCounter counter1 = new TicketCounter("Quầy 1", roomA);
        TicketCounter counter2 = new TicketCounter("Quầy 2", roomB);

        TicketSupplier supplier = new TicketSupplier(
                roomA,
                roomB,
                3,
                3000,
                3
        );
        Thread t1 = new Thread(counter1);
        Thread t2 = new Thread(counter2);
        Thread t3 = new Thread(supplier);
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Kết thúc chương trình");
        System.out.println("Vé còn lại phòng A: " + roomA.getRemainingTickets());
        System.out.println("Vé còn lại phòng B: " + roomB.getRemainingTickets());
    }
}
