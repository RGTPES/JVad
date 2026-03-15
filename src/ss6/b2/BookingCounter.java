package ss6.b2;

public class BookingCounter extends Thread {

    private TicketPool pool;
    private String name;

    public BookingCounter(String name, TicketPool pool) {
        this.name = name;
        this.pool = pool;
    }

    @Override
    public void run() {
        while (true) {
            pool.sellTicket(name);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
