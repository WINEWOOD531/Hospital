package com.solvd.hospital.models;

public class TestsDescriptionsModel {

    private int id;
    private String testDate;
    private String testAnalysis;
    private TestsModel tests;
    private PatientModel patient;

    public TestsDescriptionsModel() {
    }

    public TestsDescriptionsModel(int id, String testDate, String testAnalysis,
                                  TestsModel tests, PatientModel patient) {
        this.id = id;
        this.testDate = testDate;
        this.testAnalysis = testAnalysis;
        this.tests = tests;
        this.patient = patient;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTestDate(String testDate) {
        this.testDate = testDate;
    }

    public void setTestAnalysis(String testAnalysis) {
        this.testAnalysis = testAnalysis;
    }

    public void setTests(TestsModel tests) {
        this.tests = tests;
    }

    public void setPatient(PatientModel patient) {
        this.patient = patient;
    }

    public int getId() {
        return id;
    }

    public String getTestDate() {
        return testDate;
    }

    public String getTestAnalysis() {
        return testAnalysis;
    }

    public TestsModel getTests() {
        return tests;
    }

    public PatientModel getPatient() {
        return patient;
    }
}
