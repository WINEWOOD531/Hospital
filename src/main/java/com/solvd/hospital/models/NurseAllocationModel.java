package com.solvd.hospital.models;

public class NurseAllocationModel {

    private int id;
    private String dateIn;
    private String dateOut;
    private NursesModel nurses;
    private DoctorsModel doctors;
    private PatientModel patient;

    public NurseAllocationModel() {
    }

    public NurseAllocationModel(int id, String dateIn, String dateOut,
                                NursesModel nurses, DoctorsModel doctors, PatientModel patient) {
        this.id = id;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.nurses = nurses;
        this.doctors = doctors;
        this.patient = patient;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

    public void setNurses(NursesModel nurses) {
        this.nurses = nurses;
    }

    public void setDoctors(DoctorsModel doctors) {
        this.doctors = doctors;
    }

    public void setPatient(PatientModel patient) {
        this.patient = patient;
    }

    public int getId() {
        return id;
    }

    public String getDateIn() {
        return dateIn;
    }

    public String getDateOut() {
        return dateOut;
    }

    public NursesModel getNurses() {
        return nurses;
    }

    public DoctorsModel getDoctors() {
        return doctors;
    }

    public PatientModel getPatient() {
        return patient;
    }
}
