package com.solvd.hospital.models;

import com.solvd.hospital.dao.jdbcMySQLImpl.PatientDao;

public class RoomsModel {

    private int id;
    private String roomNumber;
    private String departmentName;
    private String dateIn;
    private String dateOut;
    private PatientDao patientDao;

    public RoomsModel() {
    }

    public RoomsModel(int id, String roomNumber, String departmentName,
                      String dateIn, String dateOut, PatientDao patientDao) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.departmentName = departmentName;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.patientDao = patientDao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

    public void setPatientDao(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    public int getId() {
        return id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getDateIn() {
        return dateIn;
    }

    public String getDateOut() {
        return dateOut;
    }

    public PatientDao getPatientDao() {
        return patientDao;
    }
}
