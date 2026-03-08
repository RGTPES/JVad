package ss1;

import java.util.Scanner;

public class b3 {
    private int age;
    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("tuoi phai lon hon 0");
        }
        this.age = age;
    }
    public int getAge() {
        return age;
    }
}
