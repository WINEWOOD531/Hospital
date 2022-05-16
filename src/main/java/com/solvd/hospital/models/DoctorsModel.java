package com.solvd.hospital.models;



import java.util.List;

public class DoctorsModel extends PersonModel{

    private int id;
    private String availableDate;
    private List<ExpertInModel> expertIn;
    private List<AppointmentModel> appointment;
    private List<NurseAllocationModel> nurseAllocations;


    public DoctorsModel() {

    }
    public DoctorsModel(int id,String availableDate,int personId) {
        this.id = id;
        this.availableDate = availableDate;
        setId(personId);
    }

    public DoctorsModel(int id, String availableDate, List<ExpertInModel> expertIn,
                        List<AppointmentModel> appointment, List<NurseAllocationModel> nurseAllocations) {
        this.id = id;
        this.availableDate = availableDate;
        this.expertIn = expertIn;
        this.appointment = appointment;
        this.nurseAllocations = nurseAllocations;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAvailableDate(String availableDate) {
        this.availableDate = availableDate;
    }


    public void setExpertIn(List<ExpertInModel> expertIn) {
        this.expertIn = expertIn;
    }

    public void setAppointment(List<AppointmentModel> appointment) {
        this.appointment = appointment;
    }

    public void setNurseAllocations(List<NurseAllocationModel> nurseAllocations) {
        this.nurseAllocations = nurseAllocations;
    }

    public int getId() {
        return id;
    }

    public String getAvailableDate() {
        return availableDate;
    }

    public List<ExpertInModel> getExpertIn() {
        return expertIn;
    }

    public List<AppointmentModel> getAppointment() {
        return appointment;
    }

    public List<NurseAllocationModel> getNurseAllocations() {
        return nurseAllocations;
    }

    @Override
    public String toString() {
        return "DoctorsModel{" +
                "id=" + id +
                ", availableDate='" + availableDate + '\'' +
                ", expertIn=" + expertIn +
                ", appointment=" + appointment +
                ", nurseAllocations=" + nurseAllocations +
                '}';
    }
}
