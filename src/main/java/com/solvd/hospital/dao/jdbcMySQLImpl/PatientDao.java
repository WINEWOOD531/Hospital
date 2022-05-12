package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.IPatientDao;
import com.solvd.hospital.models.PatientModel;
import com.solvd.hospital.models.PersonModel;
import com.solvd.hospital.utility.parsers.DataBaseConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PatientDao implements IPatientDao {

    private static final Logger LOGGER = LogManager.getLogger(PatientDao.class);
    final String deleteStatementS = "DELETE FROM Patient WHERE id=?";
    final String getStatement = "SELECT * FROM Patient WHERE age < ?";
    final String insertStatementS = "INSERT INTO Patient VALUES (?, ?, ?,?,?)";
    final String updateStatementS = "UPDATE Patient SET bloodGroup=? WHERE id=?";

    @Override
    public void createPatient(int id, int age, String bloodGroup, String sex, int personId) {
        try (Connection dbConnect = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = dbConnect.prepareStatement(insertStatementS);
            stmt.setInt(1, id);
            stmt.setInt(2, age);
            stmt.setString(3, bloodGroup);
            stmt.setString(4, sex);
            stmt.setInt(5, personId);
            int i = stmt.executeUpdate();
            LOGGER.info(i + " records inserted");
        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void updatePatient(String bloodGroup, int id) {
        try (Connection dbConnect = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = dbConnect.prepareStatement(updateStatementS);
            stmt.setString(1, bloodGroup);
            stmt.setInt(2, id);
            int i = stmt.executeUpdate();
            LOGGER.info(i + " records updated");
        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void deletePatientById(int id) {
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
    public ArrayList<PatientModel> getPatientByAge(int age) {
        ArrayList<PatientModel> patientModels = new ArrayList<>();
        try (Connection dbConnect = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = dbConnect.prepareStatement(getStatement);
            stmt.setInt(1, age);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                age = rs.getInt(2);
                String bloodGroup = rs.getString(3);
                String sex = rs.getString(4);
                int personid = rs.getInt(1);
                PatientModel patientModel = new PatientModel(id, age, bloodGroup, sex, personid);
                patientModels.add(patientModel);
                patientModel.toString();
            }
            LOGGER.info("ALL is OK!");
            return patientModels;
        } catch (Exception e) {
            LOGGER.info(e);
        }
        return null;
    }


}
