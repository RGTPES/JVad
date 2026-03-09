package ss2;

interface Authenticatable {
    String getPassword();

    default boolean isAuthenticated() {
        String password = getPassword();
        return password != null && !password.isEmpty();
    }

    static String encrypt(String rawPassword) {
        return "ENC_" + rawPassword;
    }
}

class User implements Authenticatable {

    private String password;

    public User(String password) {
        this.password = password;
    }

    @Override
    public String getPassword() {
        return password;
    }
}

public class b3 {
    public static void main(String[] args) {
        User u = new User("123456");
        System.out.println(u.isAuthenticated());
        String encrypted = Authenticatable.encrypt("123456");
        System.out.println(encrypted);
    }
}
