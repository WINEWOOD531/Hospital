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

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getId() {
        return id;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public String toString() {
        return "SpecializationModel{" +
                "id=" + id +
                ", specialization='" + specialization + '\'' +
                '}';
    }
}
