package com.solvd.hospital.models;

import java.util.List;

public class DoctorsModel {

    private int id;
    private String availableDate;
    private PersonModel person;
    private List<ExpertInModel> expertIn;
    private List<AppointmentModel> appointment;
    private List<NurseAllocationModel> nurseAllocations;

    public DoctorsModel() {
    }

    public DoctorsModel(int id, String availableDate, PersonModel person, List<ExpertInModel> expertIn,
                        List<AppointmentModel> appointment, List<NurseAllocationModel> nurseAllocations) {
        this.id = id;
        this.availableDate = availableDate;
        this.person = person;
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

    public void setPerson(PersonModel person) {
        this.person = person;
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

    public PersonModel getPerson() {
        return person;
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
}
