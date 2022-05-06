package com.solvd.hospital.dao;

import com.solvd.hospital.models.SpecializationModel;

public interface ISpecializationDao {

    void createSpecialization(SpecializationModel specialization);

    void updateSpecializationById(int id);

    void deleteSpecializationById(int id);

    ISpecializationDao getSpecializationById(int id);
}
