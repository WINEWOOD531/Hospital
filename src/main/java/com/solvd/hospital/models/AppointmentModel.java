package com.solvd.hospital.models;

import com.solvd.hospital.dao.jdbcMySQLImpl.DoctorsDao;
import com.solvd.hospital.dao.jdbcMySQLImpl.PatientDao;

public class AppointmentModel {

    private int id;
    private String appointmentDate;
    private DoctorsDao doctorsDao;
    private PatientDao patientDao;

    public AppointmentModel() {
    }

    public AppointmentModel(int id, String appointmentDate, DoctorsDao doctorsDao, PatientDao patientDao) {
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.doctorsDao = doctorsDao;
        this.patientDao = patientDao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
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

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public DoctorsDao getDoctorsDao() {
        return doctorsDao;
    }

    public PatientDao getPatientDao() {
        return patientDao;
    }
}
