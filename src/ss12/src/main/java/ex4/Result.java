package ex4;

public class Result {
    private int patients_id;
    private double value;
    public Result(int patientId, double value) {
        this.patients_id = patientId;
        this.value = value;
    }
    public int getPatientId() {
        return patients_id;
    }
    public double getValue() {
        return value;
    }
}
