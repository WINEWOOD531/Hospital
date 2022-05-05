package com.solvd.hospital.models;

public class AppointmentModel {

    private int id;
    private String appointmentDate;
    private DoctorsModel doctors;
    private PatientModel patient;

    public AppointmentModel() {
    }

    public AppointmentModel(int id, String appointmentDate, DoctorsModel doctors, PatientModel patient) {
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.doctors = doctors;
        this.patient = patient;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
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

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public DoctorsModel getDoctors() {
        return doctors;
    }

    public PatientModel getPatient() {
        return patient;
    }
}
