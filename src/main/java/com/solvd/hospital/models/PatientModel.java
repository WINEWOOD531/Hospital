package com.solvd.hospital.models;

import com.solvd.hospital.dao.jdbcMySQLImpl.PersonDao;

public class PatientModel {

    private int id;
    private int age;
    private String bloodGroup;
    private char sex;
    private PersonDao personDao;

    public PatientModel() {
    }

    public PatientModel(int id, int age, String bloodGroup, char sex, PersonDao personDao) {
        this.id = id;
        this.age = age;
        this.bloodGroup = bloodGroup;
        this.sex = sex;
        this.personDao = personDao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public char getSex() {
        return sex;
    }

    public PersonDao getPersonDao() {
        return personDao;
    }
}
