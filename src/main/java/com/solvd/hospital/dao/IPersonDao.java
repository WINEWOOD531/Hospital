package com.solvd.hospital.dao;
import com.solvd.hospital.models.PersonModel;

import java.util.List;

public interface IPersonDao {

    void createPerson(PersonModel personModel);

    void updatePerson(PersonModel personModel);

    void deletePersonById(PersonModel personModel);

    List<PersonModel> getPersonByName(String name);
}
