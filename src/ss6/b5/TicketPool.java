package ss6.b5;

import java.util.ArrayList;
import java.util.List;

public class TicketPool {
    private String roomName;
    private List<Ticket> tickets;

    public TicketPool(String roomName, int capacity) {
        this.roomName = roomName;
        tickets = new ArrayList<>();

        for (int i = 1; i <= capacity; i++) {
            tickets.add(new Ticket(roomName + "-00" + i, false));
        }
    }

    public synchronized Ticket holdTicket(boolean isVIP, String counterName) {
        for (Ticket t : tickets) {
            if (!t.isHeld()) {

                t.setHeld(true);
                t.setHoldExpiryTime(System.currentTimeMillis() + 5000);

                System.out.println(counterName +
                        ": Da giu ve " + t.getId() +
                        (isVIP ? " (VIP)" : "") +
                        ". Thanh toan trong 5s");

                return t;
            }
        }
        System.out.println(counterName + ": Het ve phong " + roomName);
        return null;
    }

    public synchronized void sellHeldTicket(Ticket ticket, String counterName) {
        if (ticket != null && ticket.isHeld()) {

            ticket.setHeld(false);

            System.out.println(counterName +
                    ": Thanh toan thanh cong ve " + ticket.getId());
        }
    }
    public synchronized void releaseExpiredTickets() {
        long now = System.currentTimeMillis();
        for (Ticket t : tickets) {

            if (t.isHeld() && now > t.getHoldExpiryTime()) {

                t.setHeld(false);

                System.out.println("TimeoutManager: Ve "
                        + t.getId()
                        + " het han giu, tra lai kho");
            }
        }
    }
}
