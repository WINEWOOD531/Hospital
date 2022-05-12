package com.solvd.hospital;

import com.solvd.hospital.dao.jdbcMySQLImpl.*;
import com.solvd.hospital.models.AppointmentModel;
import com.solvd.hospital.models.DoctorsModel;
import com.solvd.hospital.models.PatientModel;
import com.solvd.hospital.utility.parsers.JaxB;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;

import java.io.IOException;
import java.sql.SQLException;

public class Executor {

    private static final Logger LOGGER = LogManager.getLogger(Executor.class);

    //
    public static void main(String[] args) throws IOException, JAXBException, SQLException, ClassNotFoundException {
        //DomParser domParser= new DomParser();
        /*domParser.writeToXML();
        domParser.readFromXML();*/

        // DoctorsDao.getAllDoctors();
        //JaxB jaxB= new JaxB();
        //jaxB.writeToXML();
        //jaxB.readFromXML();
        //DoctorsModel doctorsModel = new DoctorsModel(10, "2022-7-11", 20);
        //PatientModel patientModel = new PatientModel(6, 28, "AB", "F");


        //DoctorsDao.getAllDoctors();

        //DoctorsDao doctorsDao = new DoctorsDao();
        //doctorsDao.getDoctorByDate("2022-06");
        //doctorsDao.createDoctor(doctorsModel);
        //doctorsDao.updateDoctor("2022-06-01",1);
        //doctorsDao.deleteDoctorById(10);

        AppointmentDao appointmentDao = new AppointmentDao();
        //appointmentDao.getAppointmentByDoctorId(2);
        //appointmentDao.deleteAppointmentById(3);
        //appointmentDao.createAppointment(3,"2022-07-30",3,3);
        //appointmentDao.updateAppointment("2022-07-15",3);

        MedicinesDao medicinesDao = new MedicinesDao();
        //medicinesDao.updateMedicines("Alkazeltser",6);
        //medicinesDao.deleteMedicinesById();
        //medicinesDao.createMedicines(9,"Some test medicines");
        //medicinesDao.getMedicinesByName("Some medicines");

        SpecializationDao specializationDao = new SpecializationDao();
        //specializationDao.createSpecialization(6,"Dentistry");
        //specializationDao.updateSpecialization("Dentistry-New",6);
        //specializationDao.deleteSpecializationById(6);
        //specializationDao.getSpecializationByName("Surgery");

        TestsDao testsDao= new TestsDao();
        //testsDao.createTests(10,"Some test 10");
        //testsDao.updateTests("Some test 10-new",10);
        //testsDao.deleteTestsById(10);
        //testsDao.getTestsByName("Some test");

        BillDao billDao = new BillDao();
        //billDao.getBillByPatientId(4);

        NursesDao nursesDao= new NursesDao();
        //nursesDao.getNurseByIdWorkExperience(5);

        NurseAllocationDao nurseAllocationDao= new NurseAllocationDao();
       // nurseAllocationDao.getNurseAllocationById(1);

        PatientDao patientDao= new PatientDao();
        //patientDao.getPatientByAge(40);

        RecordsDao recordsDao = new RecordsDao();
        //recordsDao.getRecordsByPatientId(1);

        RoomsDao roomsDao= new RoomsDao();
        //roomsDao.getRoomByDepartmentName("Ophthalmic");

        TakesDao takesDao= new TakesDao();
        //takesDao.getTakesByMedicineId(1);

        TestsDescriptionsDao testsDescriptionsDao=new TestsDescriptionsDao();
        //testsDescriptionsDao.getTestsDescriptionsByTestId(5);

    }


}
