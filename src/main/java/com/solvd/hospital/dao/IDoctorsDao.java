package com.solvd.hospital.dao;

import com.solvd.hospital.models.DoctorsModel;

public interface IDoctorsDao {

    void createDoctor(int id,String availaibleDate,int personId);

    void updateDoctorById(int id);

    void deleteDoctorById(int id);

    DoctorsModel getDoctorByDate(String date);
}
