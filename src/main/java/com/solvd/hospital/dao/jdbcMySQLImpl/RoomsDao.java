package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.IRoomsDao;
import com.solvd.hospital.models.RoomsModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RoomsDao implements IRoomsDao {

    private static final Logger LOGGER = LogManager.getLogger(RoomsDao.class);

    @Override
    public void createRoom(RoomsModel rooms) {

    }

    @Override
    public void updateRoomById(int id) {

    }

    @Override
    public void deleteRoomById(int id) {

    }

    @Override
    public IRoomsDao getRoomByPatientId(int id) {
        return null;
    }
}
