package ss6.b2;

public class TicketPool {
    private int tickets;
    private String room;
    public TicketPool(String room, int tickets) {
        this.room = room;
        this.tickets = tickets;
    }
    public synchronized void sellTicket(String counter) {
        while (tickets == 0) {
            try {
                System.out.println(counter + ": Hết vé phòng " + room + ", đang chờ...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        tickets--;
        System.out.println(counter + " bán vé " + room + "-" + String.format("%03d", tickets));
    }
    public synchronized void addTickets(int amount) {
        tickets += amount;
        System.out.println("Nhà cung cấp: Đã thêm " + amount + " vé vào phòng " + room);
        notifyAll();
    }
}
