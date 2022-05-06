package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.ISpecializationDao;
import com.solvd.hospital.models.SpecializationModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SpecializationDao implements ISpecializationDao {

    private static final Logger LOGGER = LogManager.getLogger(SpecializationDao.class);

    @Override
    public void createSpecialization(SpecializationModel specialization) {

    }

    @Override
    public void updateSpecializationById(int id) {

    }

    @Override
    public void deleteSpecializationById(int id) {

    }

    @Override
    public ISpecializationDao getSpecializationById(int id) {
        return null;
    }
}
