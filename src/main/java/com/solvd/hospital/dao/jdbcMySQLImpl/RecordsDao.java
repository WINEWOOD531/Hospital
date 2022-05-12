package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.IRecordsDao;
import com.solvd.hospital.models.PatientModel;
import com.solvd.hospital.models.RecordsModel;
import com.solvd.hospital.utility.parsers.DataBaseConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class RecordsDao implements IRecordsDao {

    private static final Logger LOGGER = LogManager.getLogger(RecordsDao.class);
    final String deleteStatementS = "DELETE FROM records WHERE id=?";
    final String getStatement = "SELECT * FROM records WHERE Patient_id = ?";
    final String insertStatementS = "INSERT INTO records VALUES (?, ?,?)";
    final String updateStatementS = "UPDATE records SET recordAnalysis=? WHERE id=?";

    @Override
    public void createRecords(int id, String recordAnalysis, int patientId) {
        try (Connection dbConnect = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = dbConnect.prepareStatement(insertStatementS);
            stmt.setInt(1, id);
            stmt.setString(2, recordAnalysis);
            stmt.setInt(3, patientId);
            int i = stmt.executeUpdate();
            LOGGER.info(i + " records inserted");
        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void updateRecords(int id, String text) {
        try (Connection dbConnect = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = dbConnect.prepareStatement(updateStatementS);
            stmt.setString(1, text);
            stmt.setInt(2, id);
            int i = stmt.executeUpdate();
            LOGGER.info(i + " records updated");
        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void deleteRecordsById(int id) {
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
    public List<RecordsModel> getRecordsByPatientId(int id) {
        ArrayList<RecordsModel> recordsModels = new ArrayList<RecordsModel>();
        PatientModel patient = new PatientModel();
        try (Connection dbConnect = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = dbConnect.prepareStatement(getStatement);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
                String recordAnalysis = rs.getString(2);
                int patientId = rs.getInt(3);
                RecordsModel recordsModel = new RecordsModel(id, recordAnalysis, patient);
                recordsModels.add(recordsModel);
                recordsModel.toString();
            }
            LOGGER.info("ALL is OK!");
            return recordsModels;
        } catch (Exception e) {
            LOGGER.info(e);
        }
        return null;
    }
}
