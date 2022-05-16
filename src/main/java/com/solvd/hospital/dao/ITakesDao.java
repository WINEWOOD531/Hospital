package com.solvd.hospital.dao;

import com.solvd.hospital.models.TakesModel;

import java.util.ArrayList;

public interface ITakesDao {

    void createTakes(TakesModel takesModel);

    void updateTakes(TakesModel takesModel);

    void deleteTakesById(TakesModel takesModel);

    ArrayList<TakesModel> getTakesByMedicineId(int id);
}
