package com.solvd.hospital.models;

public class ExpertInModel {

    private int id;
    private int doctorsId;
    private int specializationId;
    private DoctorsModel doctors;
    private SpecializationModel specialization;

    public ExpertInModel() {
    }

    public ExpertInModel(int id, DoctorsModel doctors, SpecializationModel specialization) {
        this.id = id;
        this.doctors = doctors;
        this.specialization = specialization;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDoctorsId(int doctorsId) {
        this.doctorsId = doctorsId;
    }

    public void setSpecializationId(int specializationId) {
        this.specializationId = specializationId;
    }

    public void setDoctors(DoctorsModel doctors) {
        this.doctors = doctors;
    }

    public void setSpecialization(SpecializationModel specialization) {
        this.specialization = specialization;
    }

    public int getId() {
        return id;
    }

    public int getDoctorsId() {
        return doctorsId;
    }

    public int getSpecializationId() {
        return specializationId;
    }

    public DoctorsModel getDoctors() {
        return doctors;
    }

    public SpecializationModel getSpecialization() {
        return specialization;
    }

    @Override
    public String toString() {
        return "ExpertInModel{" +
                "id=" + id +
                ", doctorsId=" + doctorsId +
                ", specializationId=" + specializationId +
                ", doctors=" + doctors +
                ", specialization=" + specialization +
                '}';
    }
}
