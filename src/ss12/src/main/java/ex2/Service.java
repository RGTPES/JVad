package ex2;


public class Service {
    private DAO dao = new DAO();
    public void update() {
        dao.updateVital(1, 36, 80);
    }
}
