package com.solvd.hospital.dao;

import com.solvd.hospital.models.NursesModel;

public interface INursesDao {

    void createNurse(NursesModel nurses);

    void updateNurseById(int id);

    void deleteNurseById(int id);

    INursesDao getNurseById(int id);
}
