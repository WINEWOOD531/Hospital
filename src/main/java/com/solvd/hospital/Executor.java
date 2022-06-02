package com.solvd.hospital;

import com.solvd.hospital.abstractFactory.DoctorsFactory;
import com.solvd.hospital.abstractFactory.IMedicinesWorkersAbstractFactory;

import com.solvd.hospital.builder.Doctor;
import com.solvd.hospital.builder.DoctorBuilder;
import com.solvd.hospital.dao.mybatisDao.MedicinesService;
import com.solvd.hospital.dao.mybatisDao.PersonService;
import com.solvd.hospital.dao.mybatisDao.TestsService;
import com.solvd.hospital.factory.Factory;
import com.solvd.hospital.factory.IHuman;
import com.solvd.hospital.observer.MyObserver;

import com.solvd.hospital.singleton.HospitalDirector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;

import java.io.IOException;
import java.sql.SQLException;

public class Executor {

    private static final Logger LOGGER = LogManager.getLogger(Executor.class);

    //private static final Logger LOGGER = LogManager.getLogger(Executor.class);
    public static void main(String[] args) throws IOException, JAXBException, SQLException, ClassNotFoundException {
/*        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();

        try {
            IMedicinesDao iMedicinesDao = session.getMapper(IMedicinesDao.class);
            MedicinesModel medicinesModel = iMedicinesDao.getMedicinesById(1);
            LOGGER.info(medicinesModel);
        } finally {
            session.close();
        }*/
        //MedicinesModel medicinesModelCreate= new MedicinesModel(9,"Aflubin");
        //MedicinesModel medicinesModelUpdate= new MedicinesModel(7,"Some test medicines name");
        /*MedicinesModel medicinesModelDelete=new MedicinesModel();
        medicinesModelDelete.setId(9);*/
        MedicinesService medicinesService = new MedicinesService();
        //medicinesService.createMedicines(medicinesModelCreate);
        //medicinesService.updateMedicines(medicinesModelUpdate);
        //medicinesService.deleteMedicinesById(medicinesModelDelete);
        //LOGGER.info(medicinesService.getMedicinesById(1));

        PersonService personService = new PersonService();
        //LOGGER.info(personService.getPersonById(3));

        TestsService testsService = new TestsService();
        //LOGGER.info(testsService.getTestsById(5));

        //<\\\\\\\\\\\\\\\Singleton//////////////////>
        HospitalDirector firstHospitalDirector = HospitalDirector.getInstance();
        HospitalDirector secondHospitalDirector = HospitalDirector.getInstance();
        firstHospitalDirector.setExperience(15);
        LOGGER.info(secondHospitalDirector.getExperience());
        //<-----------------FACTORY------------------------->
        String human = "patient";
        Factory factory = new Factory();
        IHuman ihuman = factory.getHuman(human);
        ihuman.getHuman();
        //<\\\\\\\\\\\\\\\ABSTRACT FACTORY//////////////////>
        IMedicinesWorkersAbstractFactory abstractFactory = new DoctorsFactory();
        abstractFactory.createOphthalmology();
        //<-----------------BUILDER------------------------->
        Doctor doctor = new DoctorBuilder().setName("John").setAge(35).getDoctor();
        LOGGER.info(doctor);
        ///////////////////////////////Observer//////////////////////////////////////

        MyObserver firstObserver = new MyObserver("First Observer");
        MyObserver secondObserver = new MyObserver("Second Observer");
        firstObserver.setState("Some first state");
        //secondObserver.setState("Some new state for second observer");
    }


}
