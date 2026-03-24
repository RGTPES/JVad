package ex5;

import java.util.List;

public class Service {
    private DAO dao = new DAO();
    public void showPatients() {
        List<Patients> list = dao.getAll();
        for (Patients p : list) {
            System.out.println(p.getId() + " | " + p.getName() + " | " + p.getAge() + " | " + p.getDepartment()+ " | "+ p.getDisease());
        }
    }

    public void addPatient(String name, int age, String dep, String dis) {
        Patients p = new Patients(name, age, dep, dis);
        dao.insert(p);
    }

    public void updateDisease(int id, String disease) {
        dao.updateDisease(id, disease);
    }

    public double dischargePatient(int id) {
        return dao.discharge(id);
    }
}
