package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.IMedicinesDao;
import com.solvd.hospital.models.MedicinesModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MedicinesDao implements IMedicinesDao {

    private static final Logger LOGGER = LogManager.getLogger(MedicinesDao.class);

    @Override
    public void createMedicines(MedicinesModel medicines) {

    }

    @Override
    public void updateMedicinesById(int id) {

    }

    @Override
    public void deleteMedicinesById(int id) {

    }

    @Override
    public IMedicinesDao getMedicinesById(int id) {
        return null;
    }
}
