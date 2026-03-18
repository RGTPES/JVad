package ss8.ex2;


public class SmartHomeFacade {
    private Light light;
    private Fan fan;
    private AirConditioner airConditioner;
    private TemperatureSensor temperatureSensor;

    public SmartHomeFacade(Light light, Fan fan, AirConditioner airConditioner, TemperatureSensor temperatureSensor) {
        this.light = light;
        this.fan = fan;
        this.airConditioner = airConditioner;
        this.temperatureSensor = temperatureSensor;
    }

    public void leaveHome() {
        light.turnOff();
        fan.turnOff();
        airConditioner.turnOff();
    }

    public void sleepMode() {
        light.turnOff();
        airConditioner.setTemperature(28);
        fan.setLowSpeed();
    }

    public void getCurrentTemperature() {
        double celsius = temperatureSensor.getTemperatureCelsius();

        if (temperatureSensor instanceof ThermometerAdapter) {
            ThermometerAdapter adapter = (ThermometerAdapter) temperatureSensor;
            int fahrenheit = adapter.getTemperatureFahrenheit();
            System.out.printf("Nhiet do hien tai: %.1f°C (chuyen doi tu %d°F)%n", celsius, fahrenheit);
        } else {
            System.out.printf("Nhiet do hien tai: %.1f°C%n", celsius);
        }
    }
}
