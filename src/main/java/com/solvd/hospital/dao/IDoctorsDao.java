package com.solvd.hospital.dao;

public interface IDoctorsDao {

    void createDoctor();

    void updateDoctorById();

    void deleteDoctorById();

    IDoctorsDao getDoctorById();
}
