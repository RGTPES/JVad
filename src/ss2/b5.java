package ss2;

interface UserActions {
    default void logActivity(String activity) {
        System.out.println("User log: " + activity);
    }
}

interface AdminActions {
    default void logActivity(String activity) {
        System.out.println("Admin log: " + activity);
    }
}

class SuperAdmin implements UserActions, AdminActions {
    @Override
    public void logActivity(String activity) {
        System.out.println("SuperAdmin dang ghi log...");
        UserActions.super.logActivity(activity);
        AdminActions.super.logActivity(activity);
    }
}

public class b5 {
    public static void main(String[] args) {
        SuperAdmin superAdmin = new SuperAdmin();
        superAdmin.logActivity("Dang cap nhat he thong");
    }
}