package ss8.ex1;


public class FanFactory extends DeviceFactory {
    @Override
    public Device createDevice() {
        System.out.println("FanFactory: Da tao quat moi.");
        return new Fan();
    }
}