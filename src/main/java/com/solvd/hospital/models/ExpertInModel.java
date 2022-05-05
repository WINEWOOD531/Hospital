package com.solvd.hospital.models;

import com.solvd.hospital.dao.jdbcMySQLImpl.DoctorsDao;
import com.solvd.hospital.dao.jdbcMySQLImpl.SpecializationDao;

public class ExpertInModel {

    private int id;
    private DoctorsDao doctorsDao;
    private SpecializationDao specializationDao;

    public ExpertInModel() {
    }

    public ExpertInModel(int id, SpecializationDao specializationDao) {
        this.id = id;
        this.specializationDao = specializationDao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDoctorsDao(DoctorsDao doctorsDao) {
        this.doctorsDao = doctorsDao;
    }

    public void setSpecializationDao(SpecializationDao specializationDao) {
        this.specializationDao = specializationDao;
    }

    public int getId() {
        return id;
    }

    public DoctorsDao getDoctorsDao() {
        return doctorsDao;
    }

    public SpecializationDao getSpecializationDao() {
        return specializationDao;
    }
}
