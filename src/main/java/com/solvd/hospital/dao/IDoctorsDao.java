package com.solvd.hospital.dao;

import com.solvd.hospital.models.DoctorsModel;

import java.util.List;


public interface IDoctorsDao {

    void createDoctor(DoctorsModel doctorsModel);
//void createDoctor(int id,String availaibleDate,int personId);
    void updateDoctor(String availaibleDate, int id);

    void deleteDoctorById(int id);

    List<DoctorsModel> getDoctorByDate(String date);
}
