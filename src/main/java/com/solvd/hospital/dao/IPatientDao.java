package com.solvd.hospital.dao;

import com.solvd.hospital.models.PatientModel;

public interface IPatientDao {

    void createPatient(PatientModel patient);

    void updatePatientById(int id);

    void deletePatientById(int id);

    IPatientDao getPatientById(int id);
}
