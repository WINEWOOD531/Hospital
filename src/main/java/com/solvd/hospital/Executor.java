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

        DoctorsDao doctorsDao = new DoctorsDao();
        DoctorsModel doctorsModel = new DoctorsModel();
/*        doctorsModel.setId(10);
        doctorsModel.setAvailableDate("2022-06-19");
        doctorsModel.setPersonId(23);
        doctorsDao.createDoctor(doctorsModel);*/

/*        doctorsModel.setAvailableDate("2022-06-17");
        doctorsModel.setId(10);
        doctorsDao.updateDoctor(doctorsModel);*/

        /*doctorsModel.setId(10);
        doctorsDao.deleteDoctorById(doctorsModel);*/
        //LOGGER.info(doctorsDao.getDoctorById(5));
        //LOGGER.info(doctorsDao.getALLDoctors());


        AppointmentDao appointmentDao = new AppointmentDao();
        AppointmentModel appointmentModel = new AppointmentModel();
        /*appointmentModel.setId(4);
        appointmentModel.setAppointmentDate("2022-06-20");
        appointmentModel.setDoctorsId(4);
        appointmentModel.setPatientId(4);
        appointmentDao.createAppointment(appointmentModel);*/

        /*appointmentModel.setAppointmentDate("2022-06-21");
        appointmentModel.setId(4);
        appointmentDao.updateAppointment(appointmentModel);*/

        //appointmentModel.setId(4);
        //appointmentDao.deleteAppointmentById(appointmentModel);*/

        //LOGGER.info(appointmentDao.getAllAppointments());
        //appointmentDao.getAppointmentById(3);

        MedicinesDao medicinesDao = new MedicinesDao();
        //medicinesDao.getMedicinesByName("Some medicines");
        //medicinesDao.getAllMedicines();


        SpecializationDao specializationDao = new SpecializationDao();
        //specializationDao.getSpecializationByName("Surgery");
        //specializationDao.getAllSpecialization();

        TestsDao testsDao = new TestsDao();
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
        //billDao.getBillById(4);
        //LOGGER.info(billDao.getAllBills());

        NursesDao nursesDao = new NursesDao();
        //LOGGER.info(nursesDao.getNurseById(5));
        //LOGGER.info(nursesDao.getAllNursesJoinPerson());
        //LOGGER.info(nursesDao.getAllNurses());
        NurseAllocationDao nurseAllocationDao = new NurseAllocationDao();
        //nurseAllocationDao.getNurseAllocationById(2);
        //nurseAllocationDao.getAllNurseAllocations();

        PatientDao patientDao = new PatientDao();
/*        PatientModel patientModel = new PatientModel();
        patientModel.setId(6);
        patientModel.setAge(60);
        patientModel.setBloodGroup("A");
        patientModel.setSex("F");
        patientModel.setPersonId(23);
        patientDao.createPatient(patientModel);*/

        //LOGGER.info(patientDao.getPatientById(3));
        //LOGGER.info(patientDao.getAllPatientsJoinPerson());
        //LOGGER.info(patientDao.getAllPatients());

        RecordsDao recordsDao = new RecordsDao();
        //recordsDao.getRecordsByPatientId(1);
        //recordsDao.getAllRecordsJoinPatient();
        //LOGGER.info(recordsDao.getAllRecords());
        //LOGGER.info(recordsDao.getAllRecordsJoinPatient());

        RoomsDao roomsDao = new RoomsDao();
        //LOGGER.info(roomsDao.getRoomById(2));
        //LOGGER.info(roomsDao.getAllRoomsJoinPatient());
        LOGGER.info(roomsDao.getAllRooms());


        TakesDao takesDao = new TakesDao();
        //LOGGER.info(takesDao.getTakesById(1));
        //LOGGER.info(takesDao.getAllTakes());

        TestsDescriptionsDao testsDescriptionsDao = new TestsDescriptionsDao();
        //LOGGER.info(testsDescriptionsDao.getTestsDescriptionsById(5));

        //testsDescriptionsDao.getAllTestsDescriptions();

        ExpertInDao expertInDao = new ExpertInDao();
        //LOGGER.info(expertInDao.getAllExpertIn());
        //expertInDao.getExpertInById(5);

        PersonDao personDao = new PersonDao();
        PersonModel personModel = new PersonModel();
        /*personModel.setPersonId(24);
        personModel.setFirstName("Alex");
        personModel.setLastName("Serfy");
        personModel.setPhoneNumber("(755)957-9953");
        personDao.createPerson(personModel);*/


/*        personModel.setPhoneNumber("123456789");
        personModel.setPersonId(23);
        personDao.updatePerson(personModel);*/

        /*personModel.setPersonId(24);
        personDao.deletePersonById(personModel);*/

        //personDao.getAllPersons();
        //LOGGER.info(personDao.getPersonById(5));
    }


}
