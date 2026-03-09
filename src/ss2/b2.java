package ss2;
import java.util.function.Predicate;
public class b2 {
    public static void main(String[] args) {
        Predicate<String> isValid = x -> x.length()>=8;
        System.out.println(isValid.test("12345678"));
        System.out.println(isValid.test("1234"));
    }
}
