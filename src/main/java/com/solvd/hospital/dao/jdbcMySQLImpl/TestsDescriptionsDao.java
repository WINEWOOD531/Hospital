package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.ITestsDescriptionsDao;
import com.solvd.hospital.models.TestsDescriptionsModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ResourceBundle;

public class TestsDescriptionsDao implements ITestsDescriptionsDao {

    private static final Logger LOGGER = LogManager.getLogger(TestsDescriptionsDao.class);

    ResourceBundle resource = ResourceBundle.getBundle("db");
    String url = resource.getString("db.url");
    String user = resource.getString("db.username");
    String pass = resource.getString("db.password");

    @Override
    public void createTestsDescriptions(int id, String testDate, String testAnalysis, int testsId, int patientsId) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("INSERT INTO\n" +
                    " testsdescriptions VALUES (?, ?, ?,?,?);");
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
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("UPDATE testsdescriptions" +
                    " SET testAnalysis=? WHERE id=?");
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
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("DELETE FROM testsdescriptions WHERE id=?");
            stmt.setInt(1, id);

            int i = stmt.executeUpdate();
            LOGGER.info(i + " records deleted");

        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public TestsDescriptionsModel getTestsDescriptionsByTestId(int id) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM testsdescriptions WHERE Tests_id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                LOGGER.info("\nId: " + rs.getInt(1) +
                        "\nTest Date: " + rs.getDouble(2) +
                        "\nTest Analysis:  " + rs.getString(3) +
                        "\n`Tests_id`:  " + rs.getInt(4) +
                        "\nPatient_id:  " + rs.getInt(5));
            }
        } catch (Exception e) {
            LOGGER.info(e);
        }
        return null;
    }
}
