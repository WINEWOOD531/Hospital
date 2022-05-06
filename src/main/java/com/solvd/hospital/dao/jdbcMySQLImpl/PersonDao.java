package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.IPersonDao;
import com.solvd.hospital.models.PersonModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PersonDao implements IPersonDao {

    private static final Logger LOGGER = LogManager.getLogger(PersonDao.class);
    PersonModel pm = new PersonModel();

    @Override
    public void createPerson(PersonModel person) {

    }

    @Override
    public void updatePersonById(int id) {

    }

    @Override
    public void deletePersonById(int id) {

    }

    @Override
    public IPersonDao getPersonById(int id) {
        return null;
    }
}
