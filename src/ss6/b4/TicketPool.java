package ss6.b4;

import java.util.ArrayList;
import java.util.List;

public class TicketPool {
    private String roomName;
    private List<Ticket> tickets;
    public TicketPool(String roomName, int total) {
        this.roomName = roomName;
        tickets = new ArrayList<>();

        for (int i = 1; i <= total; i++) {
            tickets.add(new Ticket(roomName + "-" + i, roomName));
        }
    }
    public synchronized Ticket sellTicket() {
        for (Ticket t : tickets) {
            if (!t.isSold()) {
                t.setSold(true);
                return t;
            }
        }
        return null;
    }
    public int remainingTickets() {
        int count = 0;
        for (Ticket t : tickets) {
            if (!t.isSold()) {
                count++;
            }
        }
        return count;
    }
}
