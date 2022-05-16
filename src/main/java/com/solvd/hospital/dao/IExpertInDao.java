package com.solvd.hospital.dao;

import com.solvd.hospital.models.ExpertInModel;

import java.util.List;

public interface IExpertInDao {

    void createExpertIn(ExpertInModel expertInModel);

    void updateExpertIn(ExpertInModel expertInModel);

    void deleteExpertInById(ExpertInModel expertInModel);

    List<ExpertInModel> getAllExpertInBySpecializationId(int id);
}
