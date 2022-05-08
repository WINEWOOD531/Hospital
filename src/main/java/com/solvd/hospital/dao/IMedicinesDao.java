package com.solvd.hospital.dao;

import com.solvd.hospital.models.MedicinesModel;

public interface IMedicinesDao {

    void createMedicines(MedicinesModel medicines);

    void updateMedicines(String medicineName,int id);

    void deleteMedicinesById(int id);

    MedicinesModel getMedicinesByName(String medicineName);
}
