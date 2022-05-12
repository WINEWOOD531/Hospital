package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.ITakesDao;
import com.solvd.hospital.models.MedicinesModel;
import com.solvd.hospital.models.PatientModel;
import com.solvd.hospital.models.TakesModel;
import com.solvd.hospital.utility.parsers.DataBaseConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;


public class TakesDao implements ITakesDao {

    private static final Logger LOGGER = LogManager.getLogger(TakesDao.class);
    final String deleteStatementS = "DELETE FROM takes WHERE id=?";
    final String getStatement = "SELECT * FROM takes WHERE Medicines_id = ?";
    final String insertStatementS = "INSERT INTO takes VALUES (?, ?, ?,?,?)";
    final String updateStatementS = "UPDATE takes SET quantiti=? WHERE id=?";

    @Override
    public void createTakes(int id, Double quantiti, String takesDate, int medicinessId, int patientsId) {
        try (Connection con = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(insertStatementS);
            stmt.setInt(1, id);
            stmt.setDouble(2, quantiti);
            stmt.setString(3, takesDate);
            stmt.setInt(4, medicinessId);
            stmt.setInt(5, patientsId);
            int i = stmt.executeUpdate();
            LOGGER.info(i + " records inserted");
        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void updateTakes(Double quantiti, int id) {
        try (Connection con = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(updateStatementS);
            stmt.setDouble(1, quantiti);
            stmt.setInt(2, id);
            int i = stmt.executeUpdate();
            LOGGER.info(i + " records updated");
        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void deleteTakesById(int id) {
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
    public ArrayList<TakesModel> getTakesByMedicineId(int id) {
        ArrayList<TakesModel>takesModels= new ArrayList<>();
        MedicinesModel medicinesModel= new MedicinesModel();
        PatientModel patient = new PatientModel();
        try (Connection con = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(getStatement);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
                Double quantiti = rs.getDouble(2);
                String takesDate = rs.getString(3);
                int medicinesId = rs.getInt(4);
                int patientId = rs.getInt(5);
                TakesModel takesModel= new TakesModel(id,quantiti,takesDate,medicinesModel,patient);
                takesModels.add(takesModel);
                takesModel.toString();
            }
            LOGGER.info("ALL is OK!");
            return takesModels;
        } catch (Exception e) {
            LOGGER.info(e);
        }
        return null;
    }
}
