package com.solvd.hospital.singleton;

public class HospitalDirector {
    private int experience = 10;
    static HospitalDirector hospitalDirector = new HospitalDirector();

    private HospitalDirector() {

    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }

    public static HospitalDirector getInstance() {
        return hospitalDirector;
    }
}
