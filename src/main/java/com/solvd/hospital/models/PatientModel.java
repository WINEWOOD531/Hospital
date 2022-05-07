package com.solvd.hospital.models;

public class PatientModel extends PersonModel{

    private int id;
    private int age;
    private String bloodGroup;
    private String sex;
    private PersonModel person;

    public PatientModel(int i, int i1, String s, String f) {
    }

    public PatientModel(int id, int age, String bloodGroup, String sex, PersonModel person) {
        this.id = id;
        this.age = age;
        this.bloodGroup = bloodGroup;
        this.sex = sex;
        this.person = person;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setPerson(PersonModel person) {
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getSex() {
        return sex;
    }

    public PersonModel getPerson() {
        return person;
    }
}
