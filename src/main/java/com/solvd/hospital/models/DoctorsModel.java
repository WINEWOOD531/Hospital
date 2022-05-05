package com.solvd.hospital.models;

import com.solvd.hospital.dao.jdbcMySQLImpl.AppointmentDao;
import com.solvd.hospital.dao.jdbcMySQLImpl.ExpertInDao;
import com.solvd.hospital.dao.jdbcMySQLImpl.NurseAllocation;
import com.solvd.hospital.dao.jdbcMySQLImpl.PersonDao;

import java.util.List;

public class DoctorsModel {

    private int id;
    private String availableDate;
    private PersonDao personDao;
    private List<ExpertInDao> expertIn;
    private List<AppointmentDao> appointment;
    private List<NurseAllocation> nurseAllocations;

    public DoctorsModel() {
    }

    public DoctorsModel(int id, String availableDate, PersonDao personDao, List<ExpertInDao> expertIn,
                        List<AppointmentDao> appointment, List<NurseAllocation> nurseAllocations) {
        this.id = id;
        this.availableDate = availableDate;
        this.personDao = personDao;
        this.expertIn = expertIn;
        this.appointment = appointment;
        this.nurseAllocations = nurseAllocations;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAvailableDate(String availableDate) {
        this.availableDate = availableDate;
    }

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    public void setExpertIn(List<ExpertInDao> expertIn) {
        this.expertIn = expertIn;
    }

    public void setAppointment(List<AppointmentDao> appointment) {
        this.appointment = appointment;
    }

    public void setNurseAllocations(List<NurseAllocation> nurseAllocations) {
        this.nurseAllocations = nurseAllocations;
    }

    public int getId() {
        return id;
    }

    public String getAvailableDate() {
        return availableDate;
    }

    public PersonDao getPersonDao() {
        return personDao;
    }

    public List<ExpertInDao> getExpertIn() {
        return expertIn;
    }

    public List<AppointmentDao> getAppointment() {
        return appointment;
    }

    public List<NurseAllocation> getNurseAllocations() {
        return nurseAllocations;
    }
}
