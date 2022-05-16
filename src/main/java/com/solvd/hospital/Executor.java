package com.solvd.hospital;

import com.solvd.hospital.dao.jdbcMySQLImpl.*;
import com.solvd.hospital.models.*;
import com.solvd.hospital.utility.parsers.JaxB;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;

import java.io.IOException;
import java.sql.SQLException;

public class Executor {

    private static final Logger LOGGER = LogManager.getLogger(Executor.class);


    public static void main(String[] args) throws IOException, JAXBException, SQLException, ClassNotFoundException {

        DoctorsDao doctorsDao= new DoctorsDao();
       //doctorsDao.getALLDoctors();
        //doctorsDao.getDoctorByDate("2022-05");


        AppointmentDao appointmentDao = new AppointmentDao();
        //appointmentDao.getAllAppointments();
        //appointmentDao.getAppointmentByDoctorId(3);

        MedicinesDao medicinesDao = new MedicinesDao();
        //medicinesDao.getMedicinesByName("Some medicines");
        //medicinesDao.getAllMedicines();


        SpecializationDao specializationDao = new SpecializationDao();
        //specializationDao.getSpecializationByName("Surgery");
        //specializationDao.getAllSpecialization();

        TestsDao testsDao= new TestsDao();
        //TestsModel testsModel= new TestsModel(10,"Test Update New Example Test Name");
        //TestsModel testsModel= new TestsModel(10);
/*        testsModel.setId(10);
        testsModel.setTestName("New Example Test Name");*/
        //testsDao.createTests(testsModel);
        //testsDao.updateTests(testsModel);
        //testsDao.deleteTestsById(testsModel);

        //testsDao.createTests(10,"Some test 10");
        //testsDao.updateTests("Some test 10-new",10);
        //testsDao.deleteTestsById(10);
        //testsDao.getTestsByName("Some test");
        //testsDao.getAllTests();

        BillDao billDao = new BillDao();
        //billDao.getAllBillsByPatientId(4);
        //billDao.getAllBills();

        NursesDao nursesDao= new NursesDao();
        //nursesDao.getNurseByIdWorkExperience(5);
       //nursesDao.getAllNursesJoinPerson();
        //nursesDao.getAllNurses();

        NurseAllocationDao nurseAllocationDao= new NurseAllocationDao();
        //nurseAllocationDao.getNurseAllocationById(2);
        //nurseAllocationDao.getAllNurseAllocations();

        PatientDao patientDao= new PatientDao();
        //patientDao.getPatientByAge(40);
        //patientDao.getAllPatientsJoinPerson();
        //patientDao.getAllPatients();

        RecordsDao recordsDao = new RecordsDao();
        //recordsDao.getRecordsByPatientId(1);
        //recordsDao.getAllRecordsJoinPatient();
        //recordsDao.getAllRecords();

        RoomsDao roomsDao= new RoomsDao();
        //roomsDao.getRoomByDepartmentName("Ophthalmic");
        //roomsDao.getAllRoomsJoinPatient();
        //roomsDao.getAllRooms();


        TakesDao takesDao= new TakesDao();
        //takesDao.getTakesByMedicineId(1);
        //takesDao.getAllTakes();

        TestsDescriptionsDao testsDescriptionsDao=new TestsDescriptionsDao();
        //testsDescriptionsDao.getTestsDescriptionsByTestId(5);

        //testsDescriptionsDao.getAllTestsDescriptions();

        ExpertInDao expertInDao= new ExpertInDao();
        //expertInDao.getAllExpertIn();
        //expertInDao.getAllExpertInBySpecializationId(5);

        PersonDao  personDao= new PersonDao();
        PersonModel personModel= new PersonModel();
        /*personModel.setPersonId(23);
        personModel.setFirstName("Alex");
        personModel.setLastName("Serfy");
        personModel.setPhoneNumber("(755)957-9953");
        personDao.createPerson(personModel);*/


/*        personModel.setPhoneNumber("123456789");
        personModel.setPersonId(23);
        personDao.updatePerson(personModel);*/

        /*personModel.setPersonId(23);
        personDao.deletePersonById(personModel);*/

        //personDao.getAllPersons();
        //personDao.getPersonByName("Maria");
    }


}
