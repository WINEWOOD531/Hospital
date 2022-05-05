package com.solvd.hospital.models;

import com.solvd.hospital.dao.jdbcMySQLImpl.PatientDao;

public class RecordsModel {

    private int id;
    private String recordAnalysis;
    private PatientDao patientDao;

    public RecordsModel() {
    }

    public RecordsModel(int id, String recordAnalysis, PatientDao patientDao) {
        this.id = id;
        this.recordAnalysis = recordAnalysis;
        this.patientDao = patientDao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRecordAnalysis(String recordAnalysis) {
        this.recordAnalysis = recordAnalysis;
    }

    public void setPatientDao(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    public int getId() {
        return id;
    }

    public String getRecordAnalysis() {
        return recordAnalysis;
    }

    public PatientDao getPatientDao() {
        return patientDao;
    }
}
