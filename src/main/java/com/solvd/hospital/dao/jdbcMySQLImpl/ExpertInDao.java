package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.IExpertInDao;
import com.solvd.hospital.models.ExpertInModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExpertInDao implements IExpertInDao {

    private static final Logger LOGGER = LogManager.getLogger(ExpertInDao.class);

    @Override
    public void createExpertIn(ExpertInModel expertIn) {

    }

    @Override
    public void updateExpertInById(int id) {

    }

    @Override
    public void deleteExpertInById(int id) {

    }

    @Override
    public IExpertInDao getExpertInById(int id) {
        return null;
    }
}
