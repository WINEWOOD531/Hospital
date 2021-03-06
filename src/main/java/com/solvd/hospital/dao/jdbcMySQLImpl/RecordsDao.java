package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.IRecordsDao;
import com.solvd.hospital.models.PatientModel;
import com.solvd.hospital.models.RecordsModel;
import com.solvd.hospital.utility.connection.DataBaseConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class RecordsDao implements IRecordsDao {

    private static final Logger LOGGER = LogManager.getLogger(RecordsDao.class);
    final String deleteStatementS = "DELETE FROM records WHERE id=?";
    final String getStatement = "SELECT * FROM records WHERE id=?";
    final String insertStatementS = "INSERT INTO records VALUES (?, ?,?)";
    final String updateStatementS = "UPDATE records SET recordAnalysis=? WHERE id=?";
    private static final String GET_ALL = "SELECT * FROM records";
    final String INNERJOIN = "SELECT records.id,records.recordAnalysis,patient.id,patient.age," +
            "patient.bloodGroup,patient.sex FROM hospital.records" +
            " INNER JOIN hospital.patient ON records.Patient_id = patient.id";
    PreparedStatement statement = null;
    ResultSet result = null;

    @Override
    public void createRecords(RecordsModel recordsModel) {
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(insertStatementS);
            statement.setInt(1, recordsModel.getId());
            statement.setString(2, recordsModel.getRecordAnalysis());
            statement.setInt(3, recordsModel.getPatient().getId());
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
    public void updateRecords(RecordsModel recordsModel) {
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(updateStatementS);
            statement.setString(1, recordsModel.getRecordAnalysis());
            statement.setInt(2, recordsModel.getId());
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
    public void deleteRecordsById(RecordsModel recordsModel) {
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(deleteStatementS);
            statement.setInt(1, recordsModel.getId());
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
    public RecordsModel getRecordById(int id) {
        Connection dbConnect = DataBaseConnection.getConnection();
        PatientModel patient = new PatientModel();
        RecordsModel recordsModel = new RecordsModel();
        try {
            statement = dbConnect.prepareStatement(getStatement);
            statement.setInt(1, id);
            result = statement.executeQuery();
            while (result.next()) {
                recordsModel.setRecordAnalysis(result.getString(2));
                recordsModel.setRecordsId(result.getInt(3));
                patient.setId(result.getInt(1));
                recordsModel.setPatient(patient);
                recordsModel.toString();
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
        return recordsModel;
    }

    public List<RecordsModel> getAllRecords() {
        ArrayList<RecordsModel> recordsModels = new ArrayList<RecordsModel>();
        PatientModel patient = new PatientModel();
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(GET_ALL);
            result = statement.executeQuery();
            while (result.next()) {
                RecordsModel recordsModel = new RecordsModel();
                //recordsModel.setId(result.getInt(1));
               /* recordsModel.setPatient(new PatientDao().getPatientById(result.getInt("id")));*/
                PatientDao patientDao= new PatientDao();
                recordsModel.setPatient(patientDao.getPatientById(result.getInt(6)));
                recordsModel.setRecordAnalysis(result.getString(2));
                recordsModel.setRecordsId(result.getInt(3));
                recordsModels.add(recordsModel);
                recordsModel.toString();
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
        return recordsModels;
    }

    public List<RecordsModel> getAllRecordsJoinPatient() {
        ArrayList<RecordsModel> recordsModels = new ArrayList<RecordsModel>();
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(INNERJOIN);
            result = statement.executeQuery();
            while (result.next()) {
                RecordsModel recordsModel = new RecordsModel();
                recordsModel.setId(result.getInt("patient.id"));
                recordsModel.setRecordAnalysis(result.getString("recordAnalysis"));
                recordsModel.setRecordsId(result.getInt("id"));
                PatientDao patientDao= new PatientDao();
                recordsModel.setPatient(patientDao.getPatientById(result.getInt("id")));
                recordsModels.add(recordsModel);
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
        return recordsModels;
    }
}
