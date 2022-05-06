package com.solvd.hospital.dao;

import com.solvd.hospital.models.PersonModel;

public interface IPersonDao {

    void createPerson(PersonModel person);

    void updatePersonById(int id);

    void deletePersonById(int id);

    IPersonDao getPersonById(int id);
}
