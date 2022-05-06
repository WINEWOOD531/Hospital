package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.INurseAllocationDao;
import com.solvd.hospital.models.NurseAllocationModel;
import com.solvd.hospital.models.NursesModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NurseAllocationDao implements INurseAllocationDao {

    private static final Logger LOGGER = LogManager.getLogger(NurseAllocationDao.class);


    @Override
    public void createNurses(NurseAllocationModel nurseAllocation) {

    }

    @Override
    public void updateNursesById(int id) {

    }

    @Override
    public void deleteNursesById(int id) {

    }

    @Override
    public INurseAllocationDao getNurseAllocationById(int id) {
        return null;
    }
}
