package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.IRecordsDao;
import com.solvd.hospital.models.RecordsModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RecordsDao implements IRecordsDao {

    private static final Logger LOGGER = LogManager.getLogger(RecordsDao.class);

    @Override
    public void createRecords(RecordsModel records) {

    }

    @Override
    public void updateRecordsById(int id) {

    }

    @Override
    public void deleteRecordsById(int id) {

    }

    @Override
    public IRecordsDao getRecordsByPatientId(int id) {
        return null;
    }
}
