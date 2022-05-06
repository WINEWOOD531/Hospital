package com.solvd.hospital.dao;

import com.solvd.hospital.models.DoctorsModel;

public interface IDoctorsDao {

    void createDoctor(DoctorsModel doctors);

    void updateDoctorById(int id);

    void deleteDoctorById(int id);

    IDoctorsDao getDoctorById(int id);
}
