package ss6.b5;

public class Ticket {

    private String id;
    private boolean isHeld;
    private boolean isVIP;
    private long holdExpiryTime;

    public Ticket(String id, boolean isVIP) {
        this.id = id;
        this.isVIP = isVIP;
        this.isHeld = false;
    }

    public String getId() {
        return id;
    }

    public boolean isHeld() {
        return isHeld;
    }

    public void setHeld(boolean held) {
        isHeld = held;
    }

    public boolean isVIP() {
        return isVIP;
    }

    public long getHoldExpiryTime() {
        return holdExpiryTime;
    }

    public void setHoldExpiryTime(long holdExpiryTime) {
        this.holdExpiryTime = holdExpiryTime;
    }
}
