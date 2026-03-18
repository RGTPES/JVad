package ss8.ex1;


public class Light implements Device {
    @Override
    public void turnOn() {
        System.out.println("Den: Bat sang.");
    }

    @Override
    public void turnOff() {
        System.out.println("Den: Tat.");
    }

    @Override
    public String getDeviceName() {
        return "Den";
    }
}
