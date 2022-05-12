package com.solvd.hospital.models;

public class SpecializationModel {

    private int id;
    private String specialization;

    public SpecializationModel() {
    }

    public SpecializationModel(int id, String specialization) {
        this.id = id;
        this.specialization = specialization;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getSpecialization() {
        return specialization;
    }
}
