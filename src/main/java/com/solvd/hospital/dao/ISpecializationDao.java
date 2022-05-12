package com.solvd.hospital.dao;

import com.solvd.hospital.models.SpecializationModel;

import java.util.List;

public interface ISpecializationDao {

    void createSpecialization(int id, String medicineName);

    void updateSpecialization(String specializationName, int id);

    void deleteSpecializationById(int id);

    List<SpecializationModel> getSpecializationByName(String name);

}
