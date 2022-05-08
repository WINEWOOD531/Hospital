package com.solvd.hospital.dao;

import com.solvd.hospital.models.ExpertInModel;

public interface IExpertInDao {

    void createExpertIn(int id,int doctorsId,int specializationId);

    void updateExpertIn(int specializationId,int id);

    void deleteExpertInById(int id);

    ExpertInModel getExpertInBySpecializationId(int id);
}
