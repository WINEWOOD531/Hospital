package com.solvd.hospital.dao;

import com.solvd.hospital.models.NursesModel;

import java.util.List;

public interface INursesDao {

    void createNurse(int id,int personId,int  workExperience);

    void updateNurse(int workExperience,int id);

    void deleteNurseById(int id);

    List<NursesModel> getNurseByIdWorkExperience(int workExperience);
}
