package com.solvd.hospital.models;

public class TestsModel {

    private int id;
    private String testName;

    public TestsModel() {
    }

    public TestsModel(int id, String testName) {
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
