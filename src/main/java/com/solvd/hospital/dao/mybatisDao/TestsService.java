package com.solvd.hospital.dao.mybatisDao;

import com.solvd.hospital.dao.ITestsDao;
import com.solvd.hospital.models.TestsModel;
import com.solvd.hospital.utility.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

public class TestsService {
    private static final Logger LOGGER = LogManager.getLogger(TestsService.class);

    public void createTests(TestsModel testsModel) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            ITestsDao iTestsDao = sqlSession.getMapper(ITestsDao.class);
            iTestsDao.createTests(testsModel);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public void updateTests(TestsModel testsModel) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            ITestsDao iTestsDao = sqlSession.getMapper(ITestsDao.class);
            iTestsDao.updateTests(testsModel);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public void deleteTestsById(TestsModel testsModel) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            ITestsDao iTestsDao = sqlSession.getMapper(ITestsDao.class);
            iTestsDao.deleteTestsById(testsModel);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public TestsModel getTestsById(Integer id) throws IOException {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            ITestsDao ITestsDao = sqlSession.getMapper(ITestsDao.class);
            return ITestsDao.getTestsById(id);
        } finally {
            sqlSession.close();
        }
    }
}
