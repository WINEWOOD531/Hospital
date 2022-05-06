package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.IAppointmentDao;
import com.solvd.hospital.models.AppointmentModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AppointmentDao implements IAppointmentDao {

    private static final Logger LOGGER = LogManager.getLogger(AppointmentDao.class);

    @Override
    public void createAppointment(AppointmentModel appointment) {

    }

    @Override
    public void updateAppointmentById(int id) {

    }

    @Override
    public void deleteAppointmentById(int id) {

    }

    @Override
    public IAppointmentDao getAppointmentById(int id) {
        return null;
    }
}
