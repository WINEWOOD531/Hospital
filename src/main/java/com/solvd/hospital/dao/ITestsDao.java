package com.solvd.hospital.dao;

import com.solvd.hospital.models.TestsModel;

public interface ITestsDao {

    void createTests(TestsModel tests);

    void updateTests(String testName,int id);

    void deleteTestsById(int id);

    TestsModel getTestsByName(String name);
}
