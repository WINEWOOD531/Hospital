package com.solvd.hospital.dao;

import com.solvd.hospital.models.RecordsModel;

public interface IRecordsDao {

    void createRecords(RecordsModel records);

    void updateRecordsById(int id);

    void deleteRecordsById(int id);

    IRecordsDao getRecordsByPatientId(int id);
}
