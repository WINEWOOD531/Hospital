package com.solvd.hospital.models;


import java.util.List;

public  class PersonModel {

    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private List<String> treatingDoctors;

    public PersonModel() {
    }

    public PersonModel(int id, String firstName, String lastName, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public PersonModel(int id, String firstName, String lastName, String phoneNumber, List<String> treatingDoctors) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.treatingDoctors = treatingDoctors;
    }

    public void setPersonId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setTreatingDoctors(List<String> treatingDoctors) {
        this.treatingDoctors = treatingDoctors;
    }

    public int getPersonId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<String> getTreatingDoctors() {
        return treatingDoctors;
    }

/*    @Override
    public String toString() {
        return "PersonModel{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }*/

    @Override
    public String toString() {
        return "PersonModel{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", treatingDoctors=" + treatingDoctors +
                '}';
    }
}
