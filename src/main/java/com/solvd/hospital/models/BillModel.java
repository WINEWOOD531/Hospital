package com.solvd.hospital.models;

public class BillModel {

    private int id;
    //private int patientId;
    private Double sum;
    private String paymentDate;
    private PatientModel patient;

    public BillModel() {
    }

    public BillModel(int id, Double sum, String paymentDate, PatientModel patient) {
        this.id = id;
        this.sum = sum;
        this.paymentDate = paymentDate;
        this.patient = patient;
    }

    public void setId(int id) {
        this.id = id;
    }

/*    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }*/

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setPatient(PatientModel patient) {
        this.patient = patient;
    }

    public int getId() {
        return id;
    }

/*    public int getPatientId() {
        return patientId;
    }*/

    public Double getSum() {
        return sum;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public PatientModel getPatient() {
        return patient;
    }

    @Override
    public String toString() {
        return "BillModel{" +
                "id=" + id +
                ", sum=" + sum +
                ", paymentDate='" + paymentDate + '\'' +
                ", patient=" + patient +
                '}';
    }
}
