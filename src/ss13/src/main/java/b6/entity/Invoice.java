package b6.entity;

import java.sql.Timestamp;

public class Invoice {
    private int invoiceId;
    private int patientId;
    private double amount;
    private Timestamp createdDate;

    public Invoice() {
    }

    public Invoice(int invoiceId, int patientId, double amount, Timestamp createdDate) {
        this.invoiceId = invoiceId;
        this.patientId = patientId;
        this.amount = amount;
        this.createdDate = createdDate;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }
}
