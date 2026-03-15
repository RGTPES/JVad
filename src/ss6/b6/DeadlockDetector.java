package ss6.b6;

public class DeadlockDetector implements Runnable {

    private boolean running = true;

    public boolean isRunning() {
        return running;
    }
    public void setRunning(boolean running) {
        this.running = running;
    }
    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(5000);
            } catch (Exception e) {}
            System.out.println("Đang quét deadlock");
            System.out.println("Không phát hiện deadlock");
        }
    }
}
