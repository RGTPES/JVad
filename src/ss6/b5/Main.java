package ss6.b5;


import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        TicketPool roomA = new TicketPool("A", 3);
        TicketPool roomB = new TicketPool("B", 3);
        TicketPool roomC = new TicketPool("C", 3);

        List<TicketPool> pools = Arrays.asList(roomA, roomB, roomC);

        TimeoutManager manager = new TimeoutManager(pools);
        manager.start();

        BookingCounter c1 = new BookingCounter("Quay 1", roomA, true);
        BookingCounter c2 = new BookingCounter("Quay 2", roomA, false);
        BookingCounter c3 = new BookingCounter("Quay 3", roomB, false);
        BookingCounter c4 = new BookingCounter("Quay 4", roomC, true);
        BookingCounter c5 = new BookingCounter("Quay 5", roomC, false);

        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
    }
}
