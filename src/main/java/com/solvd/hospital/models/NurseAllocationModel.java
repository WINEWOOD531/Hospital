package com.solvd.hospital.models;

import com.solvd.hospital.dao.jdbcMySQLImpl.DoctorsDao;
import com.solvd.hospital.dao.jdbcMySQLImpl.NursesDao;
import com.solvd.hospital.dao.jdbcMySQLImpl.PatientDao;

public class NurseAllocationModel {

    private int id;
    private String dateIn;
    private String dateOut;
    private NursesDao nursesDao;
    private DoctorsDao doctorsDao;
    private PatientDao patientDao;

    public NurseAllocationModel() {
    }

    public NurseAllocationModel(int id, String dateIn, String dateOut,
                                NursesDao nursesDao, DoctorsDao doctorsDao, PatientDao patientDao) {
        this.id = id;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.nursesDao = nursesDao;
        this.doctorsDao = doctorsDao;
        this.patientDao = patientDao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

    public void setNursesDao(NursesDao nursesDao) {
        this.nursesDao = nursesDao;
    }

    public void setDoctorsDao(DoctorsDao doctorsDao) {
        this.doctorsDao = doctorsDao;
    }

    public void setPatientDao(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    public int getId() {
        return id;
    }

    public String getDateIn() {
        return dateIn;
    }

    public String getDateOut() {
        return dateOut;
    }

    public NursesDao getNursesDao() {
        return nursesDao;
    }

    public DoctorsDao getDoctorsDao() {
        return doctorsDao;
    }

    public PatientDao getPatientDao() {
        return patientDao;
    }
}
