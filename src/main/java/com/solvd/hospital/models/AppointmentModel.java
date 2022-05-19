package com.solvd.hospital.models;

public class AppointmentModel {

    private int id;
    private int doctorsId;
    private int patientId;
    private String appointmentDate;
    private DoctorsModel doctors;
    private PatientModel patient;

    public AppointmentModel() {
    }

    public AppointmentModel(int id, String appointmentDate, int doctorsModelId, int patientModelId) {
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.doctorsId = doctorsModelId;
        this.patientId = patientModelId;
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

    public void setDoctorsId(int doctorsId) {
        this.doctorsId = doctorsId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public void setDoctors(DoctorsModel doctors) {
        this.doctors = doctors;
    }

   /* public void setDoctors(int id) {
        this.doctors = doctors;
    }*/

    public void setPatient(PatientModel patient) {
        this.patient = patient;
    }
/*    public void setPatient(int id) {
        this.patient = patient;
    }*/

    public int getId() {
        return id;
    }

    public int getDoctorsId() {
        return doctorsId;
    }

    public int getPatientId() {
        return patientId;
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

    @Override
    public String toString() {
        return "AppointmentModel{" +
                "\nid=" + id +
                ", \nappointmentDate='" + appointmentDate + '\'' +
                ", \ndoctors=" + doctors +
                ", \npatient=" + patient +
                '}';
    }
}
