package ss8.ex3;


public class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }

    @Override
    public void undo() {
        light.turnOn();
        System.out.println("Undo: Den Bat");
    }

    @Override
    public String toString() {
        return "LightOffCommand";
    }
}
