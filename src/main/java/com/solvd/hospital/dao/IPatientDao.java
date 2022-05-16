package com.solvd.hospital.dao;

import com.solvd.hospital.models.PatientModel;

import java.util.ArrayList;

public interface IPatientDao {

    void createPatient(PatientModel patientModel);

    void updatePatient(PatientModel patientModel);

    void deletePatientById(PatientModel patientModel);

    ArrayList<PatientModel> getPatientByAge(int age);
}
