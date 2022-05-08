package com.solvd.hospital.dao;
import com.solvd.hospital.models.PersonModel;

public interface IPersonDao {

    void createPerson(int id, String firstName, String lastName, String phoneNumber);

    void updatePerson(String phoneNumber, int id);

    void deletePersonById(int id);

    PersonModel getPersonByName(String name);
}
