package ss6.b5;


public class BookingCounter extends Thread {

    private String name;
    private TicketPool pool;
    private boolean vip;

    public BookingCounter(String name, TicketPool pool, boolean vip) {
        this.name = name;
        this.pool = pool;
        this.vip = vip;
    }
    @Override
    public void run() {
        try {
            Ticket ticket = pool.holdTicket(vip, name);
            Thread.sleep(3000);
            pool.sellHeldTicket(ticket, name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
