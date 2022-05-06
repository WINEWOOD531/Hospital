package com.solvd.hospital.dao;

import com.solvd.hospital.models.MedicinesModel;

public interface IMedicinesDao {

    void createMedicines(MedicinesModel medicines);

    void updateMedicinesById(int id);

    void deleteMedicinesById(int id);

    IMedicinesDao getMedicinesById(int id);
}
