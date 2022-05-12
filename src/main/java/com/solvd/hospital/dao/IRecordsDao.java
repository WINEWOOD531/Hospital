package com.solvd.hospital.dao;

import com.solvd.hospital.models.RecordsModel;

import java.util.List;

public interface IRecordsDao {

    void createRecords(int id,String recordAnalysis,int patientId);

    void updateRecords(int id,String text);

    void deleteRecordsById(int id);

    List<RecordsModel> getRecordsByPatientId(int id);
}
