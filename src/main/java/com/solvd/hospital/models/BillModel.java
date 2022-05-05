package com.solvd.hospital.models;

import com.solvd.hospital.dao.jdbcMySQLImpl.PatientDao;

public class BillModel {

    private int id;
    private Double sum;
    private String paymentDate;
    private PatientDao patientDao;

    public BillModel() {
    }

    public BillModel(int id, Double sum, String paymentDate, PatientDao patientDao) {
        this.id = id;
        this.sum = sum;
        this.paymentDate = paymentDate;
        this.patientDao = patientDao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setPatientDao(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    public int getId() {
        return id;
    }

    public Double getSum() {
        return sum;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public PatientDao getPatientDao() {
        return patientDao;
    }
}