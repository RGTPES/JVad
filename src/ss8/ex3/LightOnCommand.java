package ss8.ex3;

public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }

    @Override
    public void undo() {
        light.turnOff();
        System.out.println("Undo: Den Bat lai trang thai truoc do");
    }

    @Override
    public String toString() {
        return "LightOnCommand";
    }
}
