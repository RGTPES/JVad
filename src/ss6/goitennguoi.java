package ss6;

import java.util.Random;

public class goitennguoi extends Thread {
    String[] names = {
            "Trung", "An", "Binh", "Huy", "Nam",
            "Phuong", "Trang", "Lan", "Hoa", "Khanh"
    };
    Random random = new Random();
    @Override
    public void run() {
        while (true) {
            int index = random.nextInt(names.length);
            System.out.println("Ten duoc goi: " + names[index]);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}