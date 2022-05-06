package com.solvd.hospital.dao;

import com.solvd.hospital.models.TestsModel;

public interface ITestsDao {

    void createTests(TestsModel tests);

    void updateTestsById(int id);

    void deleteTestsById(int id);

    ITestsDao getTestsById(int id);
}
