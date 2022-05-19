package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.ITestsDescriptionsDao;
import com.solvd.hospital.models.PatientModel;
import com.solvd.hospital.models.TestsDescriptionsModel;
import com.solvd.hospital.models.TestsModel;
import com.solvd.hospital.utility.connection.DataBaseConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;


public class TestsDescriptionsDao implements ITestsDescriptionsDao {

    private static final Logger LOGGER = LogManager.getLogger(TestsDescriptionsDao.class);
    final String deleteStatementS = "DELETE FROM testsdescriptions WHERE id=?";
    final String getStatement = "SELECT * FROM testsdescriptions WHERE id=?";
    final String insertStatementS = "INSERT INTO testsdescriptions VALUES (?, ?, ?,?,?)";
    final String updateStatementS = "UPDATE testsdescriptions SET testAnalysis=? WHERE id=?";
    private static final String GET_ALL = "SELECT * FROM testsdescriptions";
    PreparedStatement statement = null;
    ResultSet result = null;

    @Override
    public void createTestsDescriptions(TestsDescriptionsModel testsDescriptionsModel) {
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(insertStatementS);
            statement.setInt(1, testsDescriptionsModel.getId());
            statement.setString(2, testsDescriptionsModel.getTestDate());
            statement.setString(3, testsDescriptionsModel.getTestAnalysis());
            statement.setInt(4, testsDescriptionsModel.getTests().getId());
            statement.setInt(5, testsDescriptionsModel.getPatient().getId());
            int i = statement.executeUpdate();
            LOGGER.info(i + " records inserted");
        } catch (Exception e) {
            LOGGER.info(e);
        } finally {
            try {
                DataBaseConnection.close(dbConnect);
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void updateTestsDescriptions(TestsDescriptionsModel testsDescriptionsModel) {
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(updateStatementS);
            statement.setString(1, testsDescriptionsModel.getTestAnalysis());
            statement.setInt(2, testsDescriptionsModel.getId());
            int i = statement.executeUpdate();
            LOGGER.info(i + " records updated");
        } catch (Exception e) {
            LOGGER.info(e);
        } finally {
            try {
                DataBaseConnection.close(dbConnect);
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteTestsDescriptionsById(TestsDescriptionsModel testsDescriptionsModel) {
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(deleteStatementS);
            statement.setInt(1, testsDescriptionsModel.getId());
            int i = statement.executeUpdate();
            LOGGER.info(i + " records deleted");
        } catch (Exception e) {
            LOGGER.info(e);
        } finally {
            try {
                DataBaseConnection.close(dbConnect);
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public TestsDescriptionsModel getTestsDescriptionsById(int id) {
        TestsDescriptionsModel testsDescriptionsModel = new TestsDescriptionsModel();
        Connection dbConnect = DataBaseConnection.getConnection();
        TestsModel testsModel = new TestsModel();
        PatientModel patientModel = new PatientModel();
        try {
            statement = dbConnect.prepareStatement(getStatement);
            statement.setInt(1, id);
            result = statement.executeQuery();
            while (result.next()) {
                testsDescriptionsModel.setId(result.getInt(1));
                testsDescriptionsModel.setTestDate(result.getString(2));
                testsDescriptionsModel.setTestAnalysis(result.getString(3));
/*                testsDescriptionsModel.setTestsId(result.getInt(4));
                testsDescriptionsModel.setPatientId(result.getInt(5));*/
                testsModel.setId(result.getInt("id"));
                patientModel.setId(result.getInt("id"));
                testsDescriptionsModel.setTests(testsModel);
                testsDescriptionsModel.setPatient(patientModel);
                testsDescriptionsModel.toString();
            }
        } catch (Exception e) {
            LOGGER.info(e);
        } finally {
            try {
                DataBaseConnection.close(dbConnect);
                statement.close();
                result.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return testsDescriptionsModel;
    }

    public ArrayList<TestsDescriptionsModel> getAllTestsDescriptions() {
        ArrayList<TestsDescriptionsModel> testsDescriptionsModels = new ArrayList<>();
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(GET_ALL);
            result = statement.executeQuery();
            while (result.next()) {
                TestsDescriptionsModel testsDescriptionsModel = new TestsDescriptionsModel();
                testsDescriptionsModel.setId(result.getInt(1));
                testsDescriptionsModel.setTestDate(result.getString(2));
                testsDescriptionsModel.setTestAnalysis(result.getString(3));
/*                testsDescriptionsModel.setTestsId(result.getInt(4));
                testsDescriptionsModel.setPatientId(result.getInt(5));*/
/*                testsDescriptionsModel.setTests(new TestsDao().getTestsById(result.getInt(4)));
                testsDescriptionsModel.setPatient(new PatientDao().getPatientById(result.getInt(5)));*/
                PatientDao patientDao = new PatientDao();
                TestsDao testsDao = new TestsDao();
                testsDescriptionsModel.setTests(testsDao.getTestsById(result.getInt(4)));
                testsDescriptionsModel.setPatient(patientDao.getPatientById(result.getInt(5)));
                testsDescriptionsModels.add(testsDescriptionsModel);
                testsDescriptionsModel.toString();
            }
        } catch (Exception e) {
            LOGGER.info(e);
        } finally {
            try {
                DataBaseConnection.close(dbConnect);
                statement.close();
                result.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return testsDescriptionsModels;
    }
}
