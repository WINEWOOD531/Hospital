package com.solvd.hospital.models;

public class RoomsModel extends PatientModel{

    private int id;
    private String roomNumber;
    private String departmentName;
    private String dateIn;
    private String dateOut;
    private PatientModel patient;

    public RoomsModel() {
    }
/*    public RoomsModel(int id, String roomNumber, String departmentName,
                      String dateIn, String dateOut,int patientId) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.departmentName = departmentName;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        //this.patient = patient;
        setId(patientId);
    }*/
    public RoomsModel(int id, String roomNumber, String departmentName,
                      String dateIn, String dateOut, PatientModel patient) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.departmentName = departmentName;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.patient = patient;
    }

    public void setRoomsId(int id) {
        this.id = id;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

    public void setPatient(PatientModel patient) {
        this.patient = patient;
    }

    public int getRoomsId() {
        return id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getDateIn() {
        return dateIn;
    }

    public String getDateOut() {
        return dateOut;
    }

    public PatientModel getPatient() {
        return patient;
    }

    @Override
    public String toString() {
        return "RoomsModel{" +
                "id=" + id +
                ", roomNumber='" + roomNumber + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", dateIn='" + dateIn + '\'' +
                ", dateOut='" + dateOut + '\'' +
                ", patient=" + patient +
                '}';
    }
}
