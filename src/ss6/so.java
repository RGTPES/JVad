package ss6;

public class so {
    private int number;
    private boolean available = false;

    public synchronized void produce(int num) {
        try {
            while (available) {
                wait();
            }

            number = num;
            System.out.println("Sinh so: " + number);

            available = true;
            notify();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void consume() {
        try {
            while (!available) {
                wait();
            }

            if (number % 2 == 0) {
                System.out.println(number + " la so chan");
            } else {
                System.out.println(number + " la so le");
            }

            available = false;
            notify();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}