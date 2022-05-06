package com.solvd.hospital.dao;

import com.solvd.hospital.models.TestsDescriptionsModel;

public interface ITestsDescriptionsDao {

    void createTestsDescriptions(TestsDescriptionsModel testsDescriptions);

    void updateTestsDescriptionsById(int id);

    void deleteTestsDescriptionsById(int id);

    ITestsDescriptionsDao getTestsDescriptionsById(int id);
}
