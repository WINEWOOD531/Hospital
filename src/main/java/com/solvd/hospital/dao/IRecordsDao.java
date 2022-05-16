package com.solvd.hospital.dao;

import com.solvd.hospital.models.RecordsModel;

import java.util.List;

public interface IRecordsDao {

    void createRecords(RecordsModel recordsModel);

    void updateRecords(RecordsModel recordsModel);

    void deleteRecordsById(RecordsModel recordsModel);

    List<RecordsModel> getRecordsByPatientId(int id);
}
