package ss6;

public class b2_TH {

    public static void main(String[] args) {

        SharedData data = new SharedData();

        Producer t1 = new Producer(data);
        Consumer t2 = new Consumer(data);

        t1.start();
        t2.start();
    }
}