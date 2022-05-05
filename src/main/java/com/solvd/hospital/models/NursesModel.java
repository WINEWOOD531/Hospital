package com.solvd.hospital.models;

import com.solvd.hospital.dao.jdbcMySQLImpl.PersonDao;

public class NursesModel {

    private int id;
    private PersonDao personDao;
    private int workExperience;

    public NursesModel() {
    }

    public NursesModel(int id, PersonDao personDao, int workExperience) {
        this.id = id;
        this.personDao = personDao;
        this.workExperience = workExperience;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    public int getId() {
        return id;
    }

    public PersonDao getPersonDao() {
        return personDao;
    }

    public int getWorkExperience() {
        return workExperience;
    }
}
