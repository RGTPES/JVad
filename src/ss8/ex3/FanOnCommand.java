package ss8.ex3;


public class FanOnCommand implements Command {
    private Fan fan;

    public FanOnCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.turnOn();
    }

    @Override
    public void undo() {
        fan.turnOff();
        System.out.println("Undo: Quat Tat");
    }

    @Override
    public String toString() {
        return "FanOnCommand";
    }
}
