package ss2;

import java.util.*;
import java.util.function.*;

class User {
    private String username;

    public User() {
        this.username = "defaultUser";
    }

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}

public class b4 {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Trung"),
                new User("Nam"),
                new User("Lan"));

        // (user) -> user.getUsername()
        Function<User, String> getName = User::getUsername;

        // (s) -> System.out.println(s)
        Consumer<String> print = System.out::println;
        for (User u : users) {
            print.accept(getName.apply(u));
        }

        // () -> new User()
        Supplier<User> createUser = User::new;
        User newUser = createUser.get();
        System.out.println("User moi: " + newUser.getUsername());
    }
}
