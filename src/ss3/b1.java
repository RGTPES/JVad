package ss3;

import java.util.List;

public class b1 {
    public record User(String username, String email, String status) {
    }

    public static void main(String[] args) {
        List<User> users = List.of(
                new User("alice", "alice@gmail.com", "ACTIVE"),
                new User("bob", "bob@gmail.com", "INACTIVE"),
                new User("charlie", "charlie@gmail.com", "ACTIVE"));
        users.forEach(user -> System.out.println("Username: " + user.username() + " | Email: " + user.email() + " | Status: " + user.status()));
    }
}
