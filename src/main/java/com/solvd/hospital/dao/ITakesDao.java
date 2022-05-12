package com.solvd.hospital.dao;

import com.solvd.hospital.models.TakesModel;

import java.util.ArrayList;

public interface ITakesDao {

    void createTakes(int id,Double quantiti, String takesDate, int medicinessId, int patientsId);

    void updateTakes(Double quantiti,int id);

    void deleteTakesById(int id);

    ArrayList<TakesModel> getTakesByMedicineId(int id);
}
