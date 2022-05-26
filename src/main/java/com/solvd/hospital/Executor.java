package com.solvd.hospital;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;

import java.io.IOException;
import java.sql.SQLException;

public class Executor {

    private static final Logger LOGGER = LogManager.getLogger(Executor.class);


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
        MedicinesService medicinesService= new MedicinesService();
        //medicinesService.createMedicines(medicinesModelCreate);
        //medicinesService.updateMedicines(medicinesModelUpdate);
        //medicinesService.deleteMedicinesById(medicinesModelDelete);
        medicinesService.getMedicinesById(1);

        PersonService personService=new PersonService();
        //personService.getPersonById(3);

        TestsService testsService= new TestsService();
        //testsService.getTestsById(5);
    }


}
