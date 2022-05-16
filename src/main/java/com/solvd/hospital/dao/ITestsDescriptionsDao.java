package com.solvd.hospital.dao;

import com.solvd.hospital.models.TestsDescriptionsModel;

import java.util.ArrayList;

public interface ITestsDescriptionsDao {

    void createTestsDescriptions(TestsDescriptionsModel testsDescriptionsModel);

    void updateTestsDescriptions(TestsDescriptionsModel testsDescriptionsModel);

    void deleteTestsDescriptionsById(TestsDescriptionsModel testsDescriptionsModel);

    ArrayList<TestsDescriptionsModel> getTestsDescriptionsByTestId(int id);
}
