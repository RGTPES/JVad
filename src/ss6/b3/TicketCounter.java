package ss6.b3;

public class TicketCounter implements Runnable {
    private String counterName;
    private TicketPool ticketPool;
    private int soldTickets;

    public TicketCounter(String counterName, TicketPool ticketPool) {
        this.counterName = counterName;
        this.ticketPool = ticketPool;
        this.soldTickets = 0;
    }

    public int getSoldTickets() {
        return soldTickets;
    }
    @Override
    public void run() {
        while (true) {
            Ticket ticket = ticketPool.sellTicket();
            if (ticket == null) {
                break;
            }
            System.out.println(counterName + " đã bán vé " + ticket.getId());
            soldTickets++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(counterName + " bán được: " + soldTickets + " vé");
    }
}
