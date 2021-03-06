package com.solvd.hospital.dao;
import com.solvd.hospital.models.PersonModel;

import java.util.ArrayList;
import java.util.List;

public interface IPersonDao {

    void createPerson(PersonModel personModel);

    void updatePerson(PersonModel personModel);

    void deletePersonById(PersonModel personModel);

    PersonModel getPersonById(int id);
}
