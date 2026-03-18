package ss8.ex5;


import java.util.ArrayList;
import java.util.List;

public class TemperatureSensor implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private int temperature;

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
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

    public int getTemperature() {
        return temperature;
    }
}
