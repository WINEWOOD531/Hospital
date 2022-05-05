package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.IRoomsDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RoomsDao implements IRoomsDao {

    private static final Logger LOGGER = LogManager.getLogger(RoomsDao.class);

    @Override
    public void createRoom() {

    }

    @Override
    public void updateRoom() {

    }

    @Override
    public void deleteRoom() {

    }

    @Override
    public IRoomsDao getRoomByPatientId() {
        return this;
    }
}
