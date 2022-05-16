package com.solvd.hospital.models;

public class TestsDescriptionsModel extends TestsModel{

    private int id;
    private int testsId;
    private int patientId;
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

    public void setTestsId(int testsId) {
        this.testsId = testsId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
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

    public int getTestsId() {
        return testsId;
    }

    public int getPatientId() {
        return patientId;
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

    @Override
    public String toString() {
        return "TestsDescriptionsModel{" +
                "id=" + id +
                ", testDate='" + testDate + '\'' +
                ", testAnalysis='" + testAnalysis + '\'' +
                ", tests=" + tests +
                ", patient=" + patient +
                '}';
    }
}
