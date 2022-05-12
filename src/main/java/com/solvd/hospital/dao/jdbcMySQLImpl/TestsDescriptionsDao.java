package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.ITestsDescriptionsDao;
import com.solvd.hospital.models.PatientModel;
import com.solvd.hospital.models.TestsDescriptionsModel;
import com.solvd.hospital.models.TestsModel;
import com.solvd.hospital.utility.parsers.DataBaseConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;


public class TestsDescriptionsDao implements ITestsDescriptionsDao {

    private static final Logger LOGGER = LogManager.getLogger(TestsDescriptionsDao.class);
    final String deleteStatementS = "DELETE FROM testsdescriptions WHERE id=?";
    final String getStatement = "SELECT * FROM testsdescriptions WHERE Tests_id = ?";
    final String insertStatementS = "INSERT INTO testsdescriptions VALUES (?, ?, ?,?,?)";
    final String updateStatementS = "UPDATE testsdescriptions SET testAnalysis=? WHERE id=?";

    @Override
    public void createTestsDescriptions(int id, String testDate, String testAnalysis, int testsId, int patientsId) {
        try (Connection con = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(insertStatementS);
            stmt.setInt(1, id);
            stmt.setString(2, testDate);
            stmt.setString(3, testAnalysis);
            stmt.setInt(4, testsId);
            stmt.setInt(5, patientsId);
            int i = stmt.executeUpdate();
            LOGGER.info(i + " records inserted");
        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void updateTestsDescriptions(String text, int id) {
        try (Connection con = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(updateStatementS);
            stmt.setString(1, text);
            stmt.setInt(2, id);
            int i = stmt.executeUpdate();
            LOGGER.info(i + " records updated");
        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void deleteTestsDescriptionsById(int id) {
        try (Connection con = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(deleteStatementS);
            stmt.setInt(1, id);
            int i = stmt.executeUpdate();
            LOGGER.info(i + " records deleted");
        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public ArrayList<TestsDescriptionsModel> getTestsDescriptionsByTestId(int id) {
        ArrayList<TestsDescriptionsModel> testsDescriptionsModels= new ArrayList<>();
        TestsModel testsModel= new TestsModel();
        PatientModel patient = new PatientModel();
        try (Connection con = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(getStatement);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                 id = rs.getInt(1);
                String testDate = rs.getString(2);
                String testAnalysis = rs.getString(3);
                int testId = rs.getInt(4);
                int patientId = rs.getInt(5);
                TestsDescriptionsModel testsDescriptionsModel= new TestsDescriptionsModel(id,testDate,
                        testAnalysis,testsModel,patient);
                testsDescriptionsModels.add(testsDescriptionsModel);
                testsDescriptionsModel.toString();
            }
            LOGGER.info("ALL is OK!");
            return testsDescriptionsModels;
        } catch (Exception e) {
            LOGGER.info(e);
        }
        return null;
    }
}
