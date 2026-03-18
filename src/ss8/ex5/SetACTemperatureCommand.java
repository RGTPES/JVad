package ss8.ex5;

public class SetACTemperatureCommand implements Command {
    private final AirConditioner airConditioner;
    private final int temperature;

    public SetACTemperatureCommand(AirConditioner airConditioner, int temperature) {
        this.airConditioner = airConditioner;
        this.temperature = temperature;
    }

    @Override
    public void execute() {
        System.out.println("SleepMode: Điều hòa set " + temperature + "°C");
        airConditioner.setTemperature(temperature);
    }
}
