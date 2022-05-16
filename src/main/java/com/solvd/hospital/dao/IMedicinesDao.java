package com.solvd.hospital.dao;

import com.solvd.hospital.models.AppointmentModel;
import com.solvd.hospital.models.MedicinesModel;

import java.util.List;

public interface IMedicinesDao {

    void createMedicines(MedicinesModel medicinesModel);

    void updateMedicines(MedicinesModel medicinesModel);

    void deleteMedicinesById(MedicinesModel medicinesModel);

    List<MedicinesModel>  getMedicinesByName(String medicineName);
}
