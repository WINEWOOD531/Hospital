package com.solvd.hospital.models;

public class NursesModel extends PersonModel{

    private int id;
    private int workExperience;

    public NursesModel() {
    }

    public NursesModel(int id,int personId,  int workExperience) {
        this.id = id;
        this.workExperience = workExperience;
        setId(personId);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    public int getId() {
        return id;
    }

    public int getWorkExperience() {
        return workExperience;
    }
}
