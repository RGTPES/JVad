package ss8.ex3;


public class Light {
    private boolean isOn = false;

    public void turnOn() {
        isOn = true;
        System.out.println("Den: Bat");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("Den: Tat");
    }

    public boolean isOn() {
        return isOn;
    }
}
