package ss3;

import java.util.*;

public class b6 {
    record Post(String title, List<String> tags) {}

    public static void main(String[] args) {
        List<Post> posts = List.of(
                new Post("Java post", List.of("java", "backend")),
                new Post("Python post", List.of("python", "data"))
        );
        List<String> allTags = posts.stream()
                .flatMap(post -> post.tags().stream())
                .toList();
        System.out.println(allTags);
    }
}
