package com.solvd.hospital.dao;

import com.solvd.hospital.models.AppointmentModel;
import com.solvd.hospital.models.MedicinesModel;

import java.util.List;

public interface IMedicinesDao {

    void createMedicines(int id, String medicineName);

    void updateMedicines(String medicineName,int id);

    void deleteMedicinesById(int id);

    List<MedicinesModel>  getMedicinesByName(String medicineName);
}
