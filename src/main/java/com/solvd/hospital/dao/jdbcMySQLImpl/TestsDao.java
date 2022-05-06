package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.ITestsDao;
import com.solvd.hospital.models.TestsModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestsDao implements ITestsDao {

    private static final Logger LOGGER = LogManager.getLogger(TestsDao.class);

    @Override
    public void createTests(TestsModel tests) {

    }

    @Override
    public void updateTestsById(int id) {

    }

    @Override
    public void deleteTestsById(int id) {

    }

    @Override
    public ITestsDao getTestsById(int id) {
        return null;
    }
}
