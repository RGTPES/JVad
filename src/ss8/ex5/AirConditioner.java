package ss8.ex5;

public class AirConditioner implements Observer {
    private int temperature = 26;
    private boolean on = false;

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        this.on = true;
        System.out.println("Điều hòa: Nhiệt độ = " + temperature);
    }

    @Override
    public void update(int roomTemperature) {
        if (roomTemperature > 30) {
            System.out.println("Điều hòa: Nhiệt độ = " + temperature + " (vẫn giữ, có thể bổ sung logic nếu muốn)");
        } else {
            System.out.println("Điều hòa: Đang theo dõi nhiệt độ phòng " + roomTemperature + "°C");
        }
    }

    public String getStatus() {
        if (!on) {
            return "Tắt";
        }
        return "Bật, nhiệt độ đặt = " + temperature + "°C";
    }
}
