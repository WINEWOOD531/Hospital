package com.solvd.hospital.dao;

import com.solvd.hospital.models.DoctorsModel;

import java.util.List;


public interface IDoctorsDao {

    void createDoctor(DoctorsModel doctorsModel);

    void updateDoctor(DoctorsModel doctorsModel);

    void deleteDoctorById(DoctorsModel doctorsModel);

    List<DoctorsModel> getDoctorByDate(String date);
}
