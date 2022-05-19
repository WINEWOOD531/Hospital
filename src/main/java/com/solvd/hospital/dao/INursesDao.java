package com.solvd.hospital.dao;

import com.solvd.hospital.models.NursesModel;

import java.util.List;

public interface INursesDao {

    void createNurse(NursesModel nursesModel);

    void updateNurse(NursesModel nursesModel);

    void deleteNurseById(NursesModel nursesModel);

    NursesModel getNurseById(int id);
}
