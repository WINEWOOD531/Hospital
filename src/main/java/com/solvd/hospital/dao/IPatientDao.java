package com.solvd.hospital.dao;

import com.solvd.hospital.models.PatientModel;

import java.util.ArrayList;

public interface IPatientDao {

    void createPatient(int id,int age,String bloodGroup,String sex,int personId);

    void updatePatient(String bloodGroup,int id);

    void deletePatientById(int id);

    ArrayList<PatientModel> getPatientByAge(int age);
}
