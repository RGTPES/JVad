package ss8.ex3;


public class Fan {
    private boolean isOn = false;

    public void turnOn() {
        isOn = true;
        System.out.println("Quat: Bat");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("Quat: Tat");
    }

    public boolean isOn() {
        return isOn;
    }
}