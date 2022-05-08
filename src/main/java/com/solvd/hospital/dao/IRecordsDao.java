package com.solvd.hospital.dao;

import com.solvd.hospital.models.RecordsModel;

public interface IRecordsDao {

    void createRecords(int id,String recordAnalysis,int patientId);

    void updateRecords(int id,String text);

    void deleteRecordsById(int id);

    RecordsModel getRecordsByPatientId(int id);
}
