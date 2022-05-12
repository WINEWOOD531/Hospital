package com.solvd.hospital.models;

public class ExpertInModel {

    private int id;
    private DoctorsModel doctors;
    private SpecializationModel specialization;

    public ExpertInModel() {
    }

    public ExpertInModel(int id, DoctorsModel doctors, SpecializationModel specialization) {
        this.id = id;
        this.doctors = doctors;
        this.specialization = specialization;
    }

    public void setPersonId(int id) {
        this.id = id;
    }

    public void setDoctors(DoctorsModel doctors) {
        this.doctors = doctors;
    }

    public void setSpecialization(SpecializationModel specialization) {
        this.specialization = specialization;
    }

    public int getPersonId() {
        return id;
    }

    public DoctorsModel getDoctors() {
        return doctors;
    }

    public SpecializationModel getSpecialization() {
        return specialization;
    }
}
