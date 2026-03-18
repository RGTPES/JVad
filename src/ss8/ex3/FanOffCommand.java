package ss8.ex3;


public class FanOffCommand implements Command {
    private Fan fan;

    public FanOffCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.turnOff();
    }

    @Override
    public void undo() {
        fan.turnOn();
        System.out.println("Undo: Quat Bat");
    }

    @Override
    public String toString() {
        return "FanOffCommand";
    }
}