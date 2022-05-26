package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.ITestsDao;

import com.solvd.hospital.models.TestsModel;
import com.solvd.hospital.utility.connection.DataBaseConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class TestsDao implements ITestsDao {

    private static final Logger LOGGER = LogManager.getLogger(TestsDao.class);

    final String deleteStatementS = "DELETE FROM Tests WHERE id=?";
    final String getStatement = "SELECT * FROM Tests WHERE id=?";
    final String insertStatementS = "INSERT INTO Tests VALUES (?, ?)";
    final String updateStatementS = "UPDATE Tests SET testName=? WHERE id=?";
    private static final String GET_ALL = "SELECT * FROM Tests";
    PreparedStatement statement = null;
    ResultSet result = null;

    @Override
    public void createTests(TestsModel testsModel) {
/*        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(insertStatementS);
            statement.setInt(1, testsModel.getId());
            statement.setString(2, testsModel.getTestName());
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
        }*/
    }

    @Override
    public void updateTests(TestsModel testsModel) {
/*        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(updateStatementS);
            statement.setString(1, testsModel.getTestName());
            statement.setInt(2, testsModel.getId());
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
        }*/
    }

    @Override
    public void deleteTestsById(TestsModel testsModel) {
/*        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(deleteStatementS);
            statement.setInt(1, testsModel.getId());
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
        }*/
    }

    @Override
    public TestsModel getTestsById(int id) {
/*        TestsModel testsModel = new TestsModel();
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(getStatement);
            statement.setInt(1, id);
            result = statement.executeQuery();
            while (result.next()) {
                testsModel.setId(result.getInt("id"));
                testsModel.setTestName(result.getString("testName"));
                testsModel.toString();
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
        return testsModel;*/

        return  null;
    }

    public List<TestsModel> getAllTests() {
        ArrayList<TestsModel> testsModels = new ArrayList<TestsModel>();
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(GET_ALL);
            result = statement.executeQuery();
            while (result.next()) {
                TestsModel testsModel = new TestsModel();
                testsModel.setId(result.getInt("id"));
                testsModel.setTestName(result.getString("testName"));
                testsModels.add(testsModel);
                testsModel.toString();
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
        return testsModels;
    }

}
