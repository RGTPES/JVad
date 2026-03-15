package ss6.b5;

import java.util.List;

public class TimeoutManager extends Thread  {
    private List<TicketPool> pools;

    public TimeoutManager(List<TicketPool> pools) {
        this.pools = pools;
    }

    @Override
    public void run() {
        while (true) {
            for(TicketPool pool : pools) {
                pool.releaseExpiredTickets();
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
