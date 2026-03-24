package btth;


import java.util.List;

public class Service {
    private DAO dao = new DAO();
    public void updateStock(int id, int qty) {
        dao.updateMedicineStock(id, qty);
    }
    public void findByPrice(double min, double max) {
        List<Medicine> list = dao.findMedicinesByPriceRange(min, max);
        list.forEach(System.out::println);
    }
    public void getTotal(int id) {
        double total = dao.calculatePrescriptionTotal(id);
        System.out.println("Total prescription cost: " + total);
    }
    public void getRevenue(String date) {
        double revenue = dao.getDailyRevenue(date);
        System.out.println("Daily revenue: " + revenue);
    }
}
