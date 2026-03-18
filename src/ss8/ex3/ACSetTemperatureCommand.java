package ss8.ex3;


public class ACSetTemperatureCommand implements Command {
    private AirConditioner airConditioner;
    private int newTemperature;
    private int oldTemperature;

    public ACSetTemperatureCommand(AirConditioner airConditioner, int newTemperature) {
        this.airConditioner = airConditioner;
        this.newTemperature = newTemperature;
    }

    @Override
    public void execute() {
        oldTemperature = airConditioner.getTemperature();
        airConditioner.setTemperature(newTemperature);
    }

    @Override
    public void undo() {
        airConditioner.setTemperature(oldTemperature);
        System.out.println("Undo: Dieu hoa: Nhiet do = " + oldTemperature + " (nhiet do cu)");
    }

    @Override
    public String toString() {
        return "ACSetTemperatureCommand(" + newTemperature + ")";
    }
}