package com.solvd.hospital.dao;

import com.solvd.hospital.models.ExpertInModel;

public interface IExpertInDao {

    void createExpertIn(ExpertInModel expertIn);

    void updateExpertInById(int id);

    void deleteExpertInById(int id);

    IExpertInDao getExpertInById(int id);
}
