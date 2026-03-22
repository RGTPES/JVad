package ss9.ex5.bussiness;


import ss9.ex5.dao.DoctorDAO;
import ss9.ex5.model.Doctor;

public class DoctorService {

    private DoctorDAO dao;

    public DoctorService(DoctorDAO dao) {
        this.dao = dao;
    }

    public void showAll() throws Exception {
        for (Doctor d : dao.getAll()) {
            System.out.println(
                    d.getDoctor_id() + " | " +
                            d.getFull_name() + " | " +
                            d.getSpecialty()
            );
        }
    }

    public void addDoctor(Doctor d) throws Exception {
        dao.add(d);
    }

    public void statistics() throws Exception {
        dao.stats();
    }
}