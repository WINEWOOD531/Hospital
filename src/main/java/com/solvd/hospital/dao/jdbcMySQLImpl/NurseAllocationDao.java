package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.INurseAllocationDao;
import com.solvd.hospital.models.DoctorsModel;
import com.solvd.hospital.models.NurseAllocationModel;
import com.solvd.hospital.models.NursesModel;
import com.solvd.hospital.models.PatientModel;
import com.solvd.hospital.utility.parsers.DataBaseConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;

public class NurseAllocationDao implements INurseAllocationDao {

    private static final Logger LOGGER = LogManager.getLogger(NurseAllocationDao.class);
    final String deleteStatementS = "DELETE FROM nurseallocation WHERE id=?";
    final String getStatement = "SELECT * FROM nurseallocation WHERE Nurses_id = ?";
    final String insertStatementS = "INSERT INTO nurseallocation VALUES (?, ?, ?,?,?,?)";
    final String updateStatementS = "UPDATE nurseallocation SET dateIn=? WHERE id=?";

    @Override
    public void createNurseAllocation(int id, String dateIn, String dateOut, int nursesId, int doctorsId, int personId) {
        try (Connection dbConnect = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = dbConnect.prepareStatement(insertStatementS);
            stmt.setInt(1, id);
            stmt.setString(2, dateIn);
            stmt.setString(3, dateOut);
            stmt.setInt(4, nursesId);
            stmt.setInt(5, doctorsId);
            stmt.setInt(6, personId);
            int i = stmt.executeUpdate();
            LOGGER.info(i + " records inserted");
        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void updateNursesAllocation(String dateIn, int id) {
        try (Connection dbConnect = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = dbConnect.prepareStatement(updateStatementS);
            stmt.setString(1, dateIn);
            stmt.setInt(2, id);
            int i = stmt.executeUpdate();
            LOGGER.info(i + " records updated");
        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void deleteNursesAllocationById(int id) {
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
    public ArrayList<NurseAllocationModel> getNurseAllocationById(int id) {
        ArrayList<NurseAllocationModel> nurseAllocationModels = new ArrayList<NurseAllocationModel>();
        DoctorsModel doctors = new DoctorsModel();
        PatientModel patient = new PatientModel();
        NursesModel nurses = new NursesModel();
        try (Connection dbConnect = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = dbConnect.prepareStatement(getStatement);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
                String dateIn = rs.getString(2);
                String dateOut = rs.getString(3);
                int nursesId = rs.getInt(4);
                int doctorsId = rs.getInt(5);
                int patientId = rs.getInt(6);
                NurseAllocationModel nurseAllocationModel = new NurseAllocationModel(id, dateIn,
                        dateOut, nurses, doctors, patient);
                nurseAllocationModels.add(nurseAllocationModel);
                nurseAllocationModel.toString();
            }
            LOGGER.info("ALL is OK!");
            return nurseAllocationModels;
        } catch (Exception e) {
            LOGGER.info(e);
        }
        return null;
    }


}
