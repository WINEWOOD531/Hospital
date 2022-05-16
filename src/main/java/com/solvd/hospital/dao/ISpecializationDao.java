package com.solvd.hospital.dao;

import com.solvd.hospital.models.SpecializationModel;

import java.util.List;

public interface ISpecializationDao {

    void createSpecialization(SpecializationModel specializationModel);

    void updateSpecialization(SpecializationModel specializationModel);

    void deleteSpecializationById(SpecializationModel specializationModel);

    List<SpecializationModel> getSpecializationByName(String name);

}
