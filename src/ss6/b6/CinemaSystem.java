package ss6.b6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CinemaSystem {

    private List<Room> rooms = new ArrayList<>();
    private List<TicketCounter> counters = new ArrayList<>();
    private ExecutorService pool;
    private int ticketPrice = 250000;

    public List<Room> getRooms() {
        return rooms;
    }

    public List<TicketCounter> getCounters() {
        return counters;
    }

    public void start(int roomCount, int ticketsPerRoom, int counterCount) {

        pool = Executors.newFixedThreadPool(counterCount + 1);

        for (int i = 0; i < roomCount; i++) {
            rooms.add(new Room("Phòng " + (char) ('A' + i), ticketsPerRoom));
        }

        for (int i = 1; i <= counterCount; i++) {
            TicketCounter counter = new TicketCounter(i, rooms);
            counters.add(counter);
            pool.execute(counter);
        }

        pool.execute(new DeadlockDetector());

        System.out.println("Đã khởi tạo hệ thống với " + roomCount + " phòng.");
    }

    public void pause() {
        for (TicketCounter c : counters) {
            c.setPaused(true);
        }
        System.out.println("Đã tạm dừng tất cả quầy bán vé.");
    }

    public void resume() {
        for (TicketCounter c : counters) {
            c.setPaused(false);
        }
        System.out.println("Đã tiếp tục hoạt động.");
    }

    public void statistics() {
        int totalSold = 0;
        System.out.println("=== THỐNG KÊ ===");
        for (Room r : rooms) {

            System.out.println(
                    r.getName() + ": Đã bán "
                            + r.getSoldTickets() + "/"
                            + r.getTotalTickets());

            totalSold += r.getSoldTickets();
        }
        System.out.println("Tổng doanh thu: " + totalSold * ticketPrice + " VNĐ");
    }
    public void stop() {
        for (TicketCounter c : counters) {
            c.stop();
        }
        if (pool != null) {
            pool.shutdownNow();
        }
        System.out.println(" dừng hệ thống");
    }
}
