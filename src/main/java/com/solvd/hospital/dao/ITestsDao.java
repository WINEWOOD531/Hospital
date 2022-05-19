package com.solvd.hospital.dao;

import com.solvd.hospital.models.TestsModel;

import java.util.List;

public interface ITestsDao {

    void createTests(TestsModel testsModel);

    void updateTests(TestsModel testsModel);

    void deleteTestsById(TestsModel testsModel);

    TestsModel getTestsById(int id);

}
