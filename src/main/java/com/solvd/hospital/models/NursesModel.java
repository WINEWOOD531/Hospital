package com.solvd.hospital.models;

public class NursesModel {

    private int id;
    private PersonModel person;
    private int workExperience;

    public NursesModel() {
    }

    public NursesModel(int id, PersonModel person, int workExperience) {
        this.id = id;
        this.person = person;
        this.workExperience = workExperience;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPerson(PersonModel person) {
        this.person = person;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    public int getId() {
        return id;
    }

    public PersonModel getPerson() {
        return person;
    }

    public int getWorkExperience() {
        return workExperience;
    }
}
