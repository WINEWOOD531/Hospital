package com.solvd.hospital.dao;

import com.solvd.hospital.models.TakesModel;

public interface ITakesDao {

    void createTakes(int id,Double quantiti, String takesDate, int medicinessId, int patientsId);

    void updateTakes(Double quantiti,int id);

    void deleteTakesById(int id);

    TakesModel getTakesByMedicineId(int id);
}
