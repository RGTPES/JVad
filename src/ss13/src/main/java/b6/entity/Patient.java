package b6.entity;


public class Patient {
    private int patientId;
    private String patientName;
    private String status;

    public Patient() {
    }

    public Patient(int patientId, String patientName, String status) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.status = status;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
