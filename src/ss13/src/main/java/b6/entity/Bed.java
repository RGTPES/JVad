package b6.entity;


public class Bed {
    private String bedId;
    private Integer patientId;
    private String status;

    public Bed() {
    }

    public Bed(String bedId, Integer patientId, String status) {
        this.bedId = bedId;
        this.patientId = patientId;
        this.status = status;
    }

    public String getBedId() {
        return bedId;
    }

    public void setBedId(String bedId) {
        this.bedId = bedId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
