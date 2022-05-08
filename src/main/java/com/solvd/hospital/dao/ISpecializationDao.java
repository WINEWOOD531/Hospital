package com.solvd.hospital.dao;

import com.solvd.hospital.models.SpecializationModel;

public interface ISpecializationDao {

    void createSpecialization(SpecializationModel specialization);

    void updateSpecialization(String specializationName, int id);

    void deleteSpecializationById(int id);

    SpecializationModel getSpecializationByName(String name);
}
