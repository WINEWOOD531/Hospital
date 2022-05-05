package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.IPersonDao;
import com.solvd.hospital.models.PersonModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PersonDao implements IPersonDao {

    private static final Logger LOGGER = LogManager.getLogger(PersonDao.class);
    PersonModel pm = new PersonModel();

    @Override
    public void createPerson() {

    }

    @Override
    public void updatePersonById() {

    }

    @Override
    public void deletePersonById() {

    }

    @Override
    public IPersonDao getPersonById() {
        return null;
    }
}
