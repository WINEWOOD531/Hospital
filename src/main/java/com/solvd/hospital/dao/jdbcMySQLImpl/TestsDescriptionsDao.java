package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.ITestsDescriptionsDao;
import com.solvd.hospital.models.TestsDescriptionsModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestsDescriptionsDao implements ITestsDescriptionsDao {

    private static final Logger LOGGER = LogManager.getLogger(TestsDescriptionsDao.class);

    @Override
    public void createTestsDescriptions(TestsDescriptionsModel testsDescriptions) {

    }

    @Override
    public void updateTestsDescriptionsById(int id) {

    }

    @Override
    public void deleteTestsDescriptionsById(int id) {

    }

    @Override
    public ITestsDescriptionsDao getTestsDescriptionsById(int id) {
        return null;
    }
}
