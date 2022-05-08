package com.solvd.hospital.dao;

import com.solvd.hospital.models.TestsDescriptionsModel;

public interface ITestsDescriptionsDao {

    void createTestsDescriptions(int id, String testDate, String testAnalysis, int testsId, int patientsId);

    void updateTestsDescriptions(String text, int id);

    void deleteTestsDescriptionsById(int id);

    TestsDescriptionsModel getTestsDescriptionsByTestId(int id);
}
