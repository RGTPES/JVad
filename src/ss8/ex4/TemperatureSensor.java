package ss8.ex4;

import java.util.ArrayList;
import java.util.List;

public class TemperatureSensor implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private int temperature;

    @Override
    public void attach(Observer o) {
        observers.add(o);
        if (o instanceof Fan) {
            System.out.println("Quạt: Đã đăng ký nhận thông báo");
        } else if (o instanceof Humidifier) {
            System.out.println("Máy tạo ẩm: Đã đăng ký");
        }
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
        System.out.println("Thiết bị đã hủy đăng ký");
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Cảm biến: Nhiệt độ = " + temperature);
        notifyObservers();
    }
}
