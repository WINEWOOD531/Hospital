package com.solvd.hospital.dao;

import com.solvd.hospital.models.TakesModel;

public interface ITakesDao {

    void createTakes(TakesModel takes);

    void updateTakesById(int id);

    void deleteTakesById(int id);

    ITakesDao getTakesById(int id);
}
