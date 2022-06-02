package com.solvd.hospital.builder;

public class Doctor {
    private String name;
    private int age;
    private String specialization;
    private double salary;
    private int experience;

    public Doctor(String name, int age, String specialization, double salary, int experience) {
        this.name = name;
        this.age = age;
        this.specialization = specialization;
        this.salary = salary;
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", specialization='" + specialization + '\'' +
                ", salary=" + salary +
                ", experience=" + experience +
                '}';
    }
}
