package com.solvd.hospital;

import com.solvd.hospital.dao.IMedicinesDao;
import com.solvd.hospital.models.MedicinesModel;
import com.solvd.hospital.utility.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

public class MedicinesService {
    private static final Logger LOGGER = LogManager.getLogger(MedicinesService.class);

    public void createMedicines(MedicinesModel medicinesModel) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IMedicinesDao iMedicinesDao = sqlSession.getMapper(IMedicinesDao.class);
            iMedicinesDao.createMedicines(medicinesModel);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public void updateMedicines(MedicinesModel medicinesModel) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IMedicinesDao iMedicinesDao = sqlSession.getMapper(IMedicinesDao.class);
            iMedicinesDao.updateMedicines(medicinesModel);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public void deleteMedicinesById(MedicinesModel medicinesModel) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IMedicinesDao iMedicinesDao = sqlSession.getMapper(IMedicinesDao.class);
            iMedicinesDao.deleteMedicinesById(medicinesModel);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public MedicinesModel getMedicinesById(Integer id) throws IOException {
/*        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IMedicinesDao iMedicinesDao = sqlSession.getMapper(IMedicinesDao.class);
            return iMedicinesDao.getMedicinesById(id);
        } finally {
            sqlSession.close();
        }*/

        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        MedicinesModel medicinesModel;
        try {
            IMedicinesDao iMedicinesDao = session.getMapper(IMedicinesDao.class);
            medicinesModel = iMedicinesDao.getMedicinesById(id);
            LOGGER.info(medicinesModel);
        } finally {
            session.close();
        }
        return medicinesModel;
    }
}








