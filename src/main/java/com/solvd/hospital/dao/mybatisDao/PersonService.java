package com.solvd.hospital.dao.mybatisDao;

import com.solvd.hospital.dao.IPersonDao;
import com.solvd.hospital.models.PersonModel;
import com.solvd.hospital.utility.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

public class PersonService {

    private static final Logger LOGGER = LogManager.getLogger(PersonService.class);

    public void createPerson(PersonModel personModel) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IPersonDao iPersonDao = sqlSession.getMapper(IPersonDao.class);
            iPersonDao.createPerson(personModel);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public void updatePerson(PersonModel personModel) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IPersonDao iPersonDao = sqlSession.getMapper(IPersonDao.class);
            iPersonDao.updatePerson(personModel);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public void deletePersonById(PersonModel personModel) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IPersonDao iPersonDao = sqlSession.getMapper(IPersonDao.class);
            iPersonDao.deletePersonById(personModel);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public PersonModel getPersonById(Integer id) throws IOException {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            IPersonDao iPersonDao = sqlSession.getMapper(IPersonDao.class);
            return iPersonDao.getPersonById(id);
        } finally {
            sqlSession.close();
        }
    }
}
