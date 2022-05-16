package com.solvd.hospital.models;

public class MedicinesModel {

    private int id;
    private String medicineName;

    public MedicinesModel() {
    }

    public MedicinesModel(int id, String medicineName) {
        this.id = id;
        this.medicineName = medicineName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public int getId() {
        return id;
    }

    public String getMedicineName() {
        return medicineName;
    }

    @Override
    public String toString() {
        return "MedicinesModel{" +
                "id=" + id +
                ", medicineName='" + medicineName + '\'' +
                '}';
    }
}
