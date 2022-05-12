package com.solvd.hospital.dao;

import com.solvd.hospital.models.TestsDescriptionsModel;

import java.util.ArrayList;

public interface ITestsDescriptionsDao {

    void createTestsDescriptions(int id, String testDate, String testAnalysis, int testsId, int patientsId);

    void updateTestsDescriptions(String text, int id);

    void deleteTestsDescriptionsById(int id);

    ArrayList<TestsDescriptionsModel> getTestsDescriptionsByTestId(int id);
}
