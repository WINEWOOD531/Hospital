package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.ITakesDao;
import com.solvd.hospital.models.TakesModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TakesDao implements ITakesDao {

    private static final Logger LOGGER = LogManager.getLogger(TakesDao.class);

    @Override
    public void createTakes(TakesModel takes) {

    }

    @Override
    public void updateTakesById(int id) {

    }

    @Override
    public void deleteTakesById(int id) {

    }

    @Override
    public ITakesDao getTakesById(int id) {
        return null;
    }
}
