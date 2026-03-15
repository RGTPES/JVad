package ss6.b6;

import java.util.List;

public class TicketCounter implements Runnable {

    private int id;
    private List<Room> rooms;
    private boolean running = true;
    private boolean paused = false;

    public TicketCounter(int id, List<Room> rooms) {
        this.id = id;
        this.rooms = rooms;
    }

    public int getId() {
        return id;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    public boolean isPaused() {
        return paused;
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        System.out.println("Quầy " + id + " bắt đầu bán vé");
        while (running) {
            if (paused) {
                continue;
            }
            for (Room room : rooms) {
                if (room.sellTicket()) {
                    System.out.println("Quầy " + id + " bán 1 vé phòng " + room.getName());
                }
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                }
            }
        }
    }
}