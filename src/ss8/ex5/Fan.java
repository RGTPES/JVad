package ss8.ex5;

public class Fan implements Observer {
    private String speed = "Tắt";

    public void setLowSpeed() {
        speed = "Thấp";
        System.out.println("Quạt: Chạy tốc độ thấp");
    }

    public void setMediumSpeed() {
        speed = "Trung bình";
        System.out.println("Quạt: Chạy tốc độ trung bình");
    }

    public void setHighSpeed() {
        speed = "Mạnh";
        System.out.println("Quạt: Nhiệt độ cao, chạy tốc độ mạnh");
    }

    @Override
    public void update(int temperature) {
        if (temperature > 30) {
            setHighSpeed();
        } else if (temperature >= 20) {
            setLowSpeed();
        } else {
            speed = "Tắt";
            System.out.println("Quạt: Nhiệt độ thấp, tự động TẮT");
        }
    }

    public String getStatus() {
        return speed;
    }
}
