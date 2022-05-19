package com.solvd.hospital.models;

public class NurseAllocationModel {

    private int id;
/*    private int nursesId;
    private int doctorsId;
    private int patientId;*/
    private String dateIn;
    private String dateOut;
    private NursesModel nurses;
    private DoctorsModel doctors;
    private PatientModel patient;

    public NurseAllocationModel() {
    }

    public NurseAllocationModel(int id,  String dateIn, String dateOut,
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

/*    public void setNursesId(int nursesId) {
        this.nursesId = nursesId;
    }

    public void setDoctorsId(int doctorsId) {
        this.doctorsId = doctorsId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }*/

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

/*    public int getNursesId() {
        return nursesId;
    }

    public int getDoctorsId() {
        return doctorsId;
    }

    public int getPatientId() {
        return patientId;
    }*/

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

    @Override
    public String toString() {
        return "NurseAllocationModel{" +
                "id=" + id +
                ", dateIn='" + dateIn + '\'' +
                ", dateOut='" + dateOut + '\'' +
                ", nurses=" + nurses +
                ", doctors=" + doctors +
                ", patient=" + patient +
                '}';
    }
}
