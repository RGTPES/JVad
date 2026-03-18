package ss8.ex5;


public class TurnOffLightCommand implements Command {
    private final Light light;

    public TurnOffLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        System.out.println("SleepMode: Tắt đèn");
        light.turnOff();
    }
}
