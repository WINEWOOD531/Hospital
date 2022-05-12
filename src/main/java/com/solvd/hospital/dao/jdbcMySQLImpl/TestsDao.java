package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.ITestsDao;

import com.solvd.hospital.models.TestsModel;
import com.solvd.hospital.utility.parsers.DataBaseConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class TestsDao implements ITestsDao {

    private static final Logger LOGGER = LogManager.getLogger(TestsDao.class);

    final String deleteStatementS = "DELETE FROM Tests WHERE id=?";
    final String getStatement = "SELECT * FROM Tests WHERE testName LIKE ? ESCAPE '!'";
    final String insertStatementS = "INSERT INTO Tests VALUES (?, ?)";
    final String updateStatementS = "UPDATE Tests SET testName=? WHERE id=?";

    @Override
    public void createTests(int id, String medicineName) {
        try (Connection dbConnect = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = dbConnect.prepareStatement(insertStatementS);
            stmt.setInt(1, id);
            stmt.setString(2, medicineName);
            int i = stmt.executeUpdate();
            LOGGER.info(i + " records inserted");
        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void updateTests(String testName, int id) {
        try (Connection dbConnect = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = dbConnect.prepareStatement(updateStatementS);
            stmt.setString(1, testName);
            stmt.setInt(2, id);
            int i = stmt.executeUpdate();
            LOGGER.info(i + " records updated");
        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void deleteTestsById(int id) {
        try (Connection dbConnect = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = dbConnect.prepareStatement(deleteStatementS);
            stmt.setInt(1, id);
            int i = stmt.executeUpdate();
            LOGGER.info(i + " records deleted");
        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public List<TestsModel> getTestsByName(String name) {
        try (Connection dbConnect = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = dbConnect.prepareStatement(getStatement);
            stmt.setString(1, name + "%");
            ResultSet rs = stmt.executeQuery();
            ArrayList<TestsModel> testsModels = new ArrayList<TestsModel>();
            while (rs.next()) {
                int id = rs.getInt(1);
                name = rs.getString(2);
                TestsModel testsModel = new TestsModel(id, name);
                testsModels.add(testsModel);
                testsModel.toString();
            }
            LOGGER.info("ALL is OK!");
            return testsModels;
        } catch (Exception e) {
            LOGGER.info(e);
        }
        return null;
    }


}
