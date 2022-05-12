package com.solvd.hospital.dao;

import com.solvd.hospital.models.TestsModel;

import java.util.List;

public interface ITestsDao {

    void createTests(int id, String medicineName);

    void updateTests(String testName,int id);

    void deleteTestsById(int id);

    List<TestsModel> getTestsByName(String name);

}
