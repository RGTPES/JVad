package ex3;


public class Service {
    private DAO dao = new DAO();
    public void showCost() {
        double cost = dao.getCost(1);
        System.out.println("Cost = " + cost);
    }
}
