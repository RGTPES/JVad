package ss9.ex5.model;


public class Doctor {
    private String doctor_id;
    private String full_name;
    private String specialty;

    public Doctor(String doctor_id, String full_name, String specialty) {
        this.doctor_id = doctor_id;
        this.full_name = full_name;
        this.specialty = specialty;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }
}
