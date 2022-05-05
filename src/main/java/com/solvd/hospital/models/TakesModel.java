package com.solvd.hospital.models;

public class TakesModel {

    private int id;
    private String testName;

    public TakesModel() {
    }

    public TakesModel(int id, String testName) {
        this.id = id;
        this.testName = testName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public int getId() {
        return id;
    }

    public String getTestName() {
        return testName;
    }
}
