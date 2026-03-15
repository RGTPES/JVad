package ss6.b1;

public class BookingCounter implements Runnable {

    private String name;
    private TicketPool first;
    private TicketPool second;

    public BookingCounter(String name, TicketPool first, TicketPool second) {
        this.name = name;
        this.first = first;
        this.second = second;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TicketPool getFirst() {
        return first;
    }

    public void setFirst(TicketPool first) {
        this.first = first;
    }

    public TicketPool getSecond() {
        return second;
    }

    public void setSecond(TicketPool second) {
        this.second = second;
    }
    public void sellCombo() {
        synchronized (first) {

            String ticket1 = first.getTicket();

            if (ticket1 == null) {
                System.out.println(name + ": Het ve " + first.getRoomName());
                return;
            }

            System.out.println(name + ": Da lay ve " + ticket1);

            try { Thread.sleep(100); } catch (Exception e) {}

            synchronized (second) {
                String ticket2 = second.getTicket();
                if (ticket2 == null) {
                    first.returnTicket();
                    System.out.println(name + ": Combo that bai");
                    return;
                }

                System.out.println(name + " ban combo: " + ticket1 + " & " + ticket2);
            }
        }
    }
    @Override
    public void run() {
        sellCombo();
    }
}
