package com.solvd.hospital.models;

import com.solvd.hospital.dao.jdbcMySQLImpl.PatientDao;
import com.solvd.hospital.dao.jdbcMySQLImpl.TestsDao;

public class TestsDescriptionsModel {

    private int id;
    private String testDate;
    private String testAnalysis;
    private TestsDao testsDao;
    private PatientDao patientDao;

    public TestsDescriptionsModel() {
    }

    public TestsDescriptionsModel(int id, String testDate, String testAnalysis,
                                  TestsDao testsDao, PatientDao patientDao) {
        this.id = id;
        this.testDate = testDate;
        this.testAnalysis = testAnalysis;
        this.testsDao = testsDao;
        this.patientDao = patientDao;
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

    public void setTestsDao(TestsDao testsDao) {
        this.testsDao = testsDao;
    }

    public void setPatientDao(PatientDao patientDao) {
        this.patientDao = patientDao;
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

    public TestsDao getTestsDao() {
        return testsDao;
    }

    public PatientDao getPatientDao() {
        return patientDao;
    }
}
