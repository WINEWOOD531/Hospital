package com.solvd.hospital.dao;

public interface IRecordsDao {

    void createRecords();

    void updateRecords();

    void deleteRecords();

    void getRecordsByPatientId();
}
