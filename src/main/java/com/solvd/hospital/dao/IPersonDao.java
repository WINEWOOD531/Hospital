package com.solvd.hospital.dao;
import com.solvd.hospital.models.PersonModel;

import java.util.List;

public interface IPersonDao {

    void createPerson(int id, String firstName, String lastName, String phoneNumber);

    void updatePerson(String phoneNumber, int id);

    void deletePersonById(int id);

    List<PersonModel> getPersonByName(String name);
}
