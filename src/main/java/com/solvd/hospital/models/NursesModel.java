package com.solvd.hospital.models;

public class NursesModel extends PersonModel {

    private int id;
    private int workExperience;
    PersonModel personModel;

    public NursesModel() {
    }

    public NursesModel(int id, int personId, int workExperience) {
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

    public void setPersonModel(PersonModel personModel) {
        this.personModel = personModel;
    }

    public int getId() {
        return id;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public PersonModel getPersonModel() {
        return personModel;
    }

/*    @Override
    public String toString() {
        return "NursesModel{" +
                "id=" + id +
                ", workExperience=" + workExperience +
                '}';
    }*/

    @Override
    public String toString() {
        return "NursesModel{" +
                "id=" + id +
                ", personModel=" + personModel +
                ", workExperience=" + workExperience +
                '}';
    }
}
