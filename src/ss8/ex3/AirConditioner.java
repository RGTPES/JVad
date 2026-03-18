package ss8.ex3;



public class AirConditioner {
    private int temperature = 25;

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Dieu hoa: Nhiet do = " + temperature);
    }

    public int getTemperature() {
        return temperature;
    }
}
