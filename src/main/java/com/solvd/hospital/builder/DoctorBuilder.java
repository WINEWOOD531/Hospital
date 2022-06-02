package com.solvd.hospital.builder;

public class DoctorBuilder {
    private String name;
    private int age;
    private String specialization;
    private double salary;
    private int experience;

    public DoctorBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public DoctorBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public DoctorBuilder setSpecialization(String specialization) {
        this.specialization = specialization;
        return this;
    }

    public DoctorBuilder setSalary(double salary) {
        this.salary = salary;
        return this;
    }

    public DoctorBuilder setExperience(int experience) {
        this.experience = experience;
        return this;
    }

    public Doctor getDoctor(){

        return new Doctor(name,age,specialization,salary,experience);
    }
}
