package ss6.b3;

import java.util.LinkedList;
import java.util.Queue;
public class TicketPool {

    private Queue<Ticket> tickets;
    private String roomName;
    private int counter;

    public TicketPool(String roomName, int initialTickets) {
        this.roomName = roomName;
        this.tickets = new LinkedList<>();
        this.counter = 1;

        for (int i = 0; i < initialTickets; i++) {
            tickets.add(new Ticket(roomName + "-" + counter++));
        }
    }

    public synchronized Ticket sellTicket() {
        return tickets.poll();
    }

    public synchronized void addTickets(int count) {
        for (int i = 0; i < count; i++) {
            tickets.add(new Ticket(roomName + "-" + counter++));
        }
    }

    public int getRemainingTickets() {
        return tickets.size();
    }

    public String getRoomName() {
        return roomName;
    }
}
