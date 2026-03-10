package ss3;

import java.util.*;

public class b4 {
    public record User(String username, String email, String status) {}

    public static void main(String[] args) {
        List<User> users = List.of(
                new User("alice", "alice@gmail.com", "ACTIVE"),
                new User("bob", "bob@yahoo.com", "INACTIVE"),
                new User("alice", "alice2@gmail.com", "ACTIVE"),
                new User("charlie", "charlie@gmail.com", "ACTIVE"),
                new User("bob", "bob2@yahoo.com", "ACTIVE")
        );
        Set<String> seen = new HashSet<>();
        users.stream().filter(u->seen.add(u.username())).forEach(System.out::println);
    }
}