package ss8.ex5;


public class Light {
    private boolean on = true;

    public void turnOff() {
        on = false;
        System.out.println("Đèn: Tắt");
    }

    public void turnOn() {
        on = true;
        System.out.println("Đèn: Bật");
    }

    public String getStatus() {
        return on ? "Bật" : "Tắt";
    }
}
