package ex1;


public class Service {
    private DAO dao = new DAO();

    public void login(String code, String pass) {
        if (dao.login(code, pass)) {
            System.out.println("Login thanh cong");
        } else {
            System.out.println("Login that bai");
        }
    }
}
