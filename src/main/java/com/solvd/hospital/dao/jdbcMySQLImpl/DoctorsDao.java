package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.IDoctorsDao;
import com.solvd.hospital.models.DoctorsModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DoctorsDao implements IDoctorsDao {

    private static final Logger LOGGER = LogManager.getLogger(DoctorsDao.class);

    @Override
    public void createDoctor(DoctorsModel doctors) {

    }

    @Override
    public void updateDoctorById(int id) {

    }

    @Override
    public void deleteDoctorById(int id) {

    }

    @Override
    public IDoctorsDao getDoctorById(int id) {
        return null;
    }
}
