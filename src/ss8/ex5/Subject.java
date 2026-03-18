package ss8.ex5;


public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
}