package ss6.b1;

public class TicketPool {
    private String roomName;
    private int tickets;
    public TicketPool(String roomName, int tickets) {
        this.roomName = roomName;
        this.tickets = tickets;
    }
    public String getTicket() {
        if (tickets > 0) {
            String ticket = roomName + "-" + tickets;
            tickets--;
            return ticket;
        }
        return null;
    }
    public void returnTicket() {
        tickets++;
    }

    public String getRoomName() {
        return roomName;
    }
}
