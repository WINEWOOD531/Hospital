package com.solvd.hospital.dao;

import com.solvd.hospital.models.ExpertInModel;

import java.util.List;

public interface IExpertInDao {

    void createExpertIn(int id,int doctorsId,int specializationId);

    void updateExpertIn(int specializationId,int id);

    void deleteExpertInById(int id);

    List<ExpertInModel> getExpertInBySpecializationId(int id);
}
