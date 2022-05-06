package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.INursesDao;
import com.solvd.hospital.models.NursesModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NursesDao implements INursesDao {

    private static final Logger LOGGER = LogManager.getLogger(NursesDao.class);

    @Override
    public void createNurse(NursesModel nurses) {

    }

    @Override
    public void updateNurseById(int id) {

    }

    @Override
    public void deleteNurseById(int id) {

    }

    @Override
    public INursesDao getNurseById(int id) {
        return null;
    }
}
