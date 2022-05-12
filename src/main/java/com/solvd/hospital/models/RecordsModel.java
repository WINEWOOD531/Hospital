package com.solvd.hospital.models;

public class RecordsModel {

    private int id;
    private String recordAnalysis;
    private PatientModel patient;

    public RecordsModel() {
    }

    public RecordsModel(int id, String recordAnalysis, PatientModel patient) {
        this.id = id;
        this.recordAnalysis = recordAnalysis;
        this.patient = patient;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRecordAnalysis(String recordAnalysis) {
        this.recordAnalysis = recordAnalysis;
    }

    public void setPatient(PatientModel patient) {
        this.patient = patient;
    }

    public int getId() {
        return id;
    }

    public String getRecordAnalysis() {
        return recordAnalysis;
    }

    public PatientModel getPatient() {
        return patient;
    }
}
