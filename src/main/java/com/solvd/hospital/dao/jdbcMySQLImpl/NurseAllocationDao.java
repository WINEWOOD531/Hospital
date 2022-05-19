package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.INurseAllocationDao;
import com.solvd.hospital.models.DoctorsModel;
import com.solvd.hospital.models.NurseAllocationModel;
import com.solvd.hospital.models.NursesModel;
import com.solvd.hospital.models.PatientModel;
import com.solvd.hospital.utility.connection.DataBaseConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;

public class NurseAllocationDao implements INurseAllocationDao {

    private static final Logger LOGGER = LogManager.getLogger(NurseAllocationDao.class);
    final String deleteStatementS = "DELETE FROM nurseallocation WHERE id=?";
    final String getStatement = "SELECT * FROM nurseallocation WHERE id = ?";
    final String insertStatementS = "INSERT INTO nurseallocation VALUES (?, ?, ?,?,?,?)";
    final String updateStatementS = "UPDATE nurseallocation SET dateIn=? WHERE id=?";
    private static final String GET_ALL = "SELECT * FROM nurseallocation";
    PreparedStatement statement = null;
    ResultSet result = null;

    @Override
    public void createNurseAllocation(NurseAllocationModel nurseAllocationModel) {
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(insertStatementS);
            statement.setInt(1, nurseAllocationModel.getId());
            statement.setString(2, nurseAllocationModel.getDateIn());
            statement.setString(3, nurseAllocationModel.getDateOut());
            statement.setInt(4, nurseAllocationModel.getNurses().getId());
            statement.setInt(5, nurseAllocationModel.getDoctors().getId());
            statement.setInt(6, nurseAllocationModel.getPatient().getId());
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
    public void updateNursesAllocation(NurseAllocationModel nurseAllocationModel) {
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(updateStatementS);
            statement.setString(1, nurseAllocationModel.getDateIn());
            statement.setInt(2, nurseAllocationModel.getId());
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
    public void deleteNursesAllocationById(NurseAllocationModel nurseAllocationModel) {
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(deleteStatementS);
            statement.setInt(1, nurseAllocationModel.getId());
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
    public NurseAllocationModel getNurseAllocationById(int id) {
        Connection dbConnect = DataBaseConnection.getConnection();
        NurseAllocationModel nurseAllocationModel = new NurseAllocationModel();
        DoctorsModel doctorsModel = new DoctorsModel();
        PatientModel patientModel = new PatientModel();
        NursesModel nursesModel = new NursesModel();
        try {
            statement = dbConnect.prepareStatement(getStatement);
            statement.setInt(1, id);
            result = statement.executeQuery();
            while (result.next()) {
                nurseAllocationModel.setId(result.getInt(1));
                nurseAllocationModel.setDateIn(result.getString(2));
                nurseAllocationModel.setDateOut(result.getString(3));
                nursesModel.setId(result.getInt("id"));
                doctorsModel.setId(result.getInt("id"));
                patientModel.setId(result.getInt("id"));
                nurseAllocationModel.setNurses(nursesModel);
                nurseAllocationModel.setDoctors(doctorsModel);
                nurseAllocationModel.setPatient(patientModel);
                nurseAllocationModel.toString();
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
        return nurseAllocationModel;
    }

    public ArrayList<NurseAllocationModel> getAllNurseAllocations() {
        ArrayList<NurseAllocationModel> nurseAllocationModels = new ArrayList<NurseAllocationModel>();
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(GET_ALL);
            result = statement.executeQuery();
            while (result.next()) {
                NurseAllocationModel nurseAllocationModel = new NurseAllocationModel();
                nurseAllocationModel.setId(result.getInt(1));
                nurseAllocationModel.setDateIn(result.getString(2));
                nurseAllocationModel.setDateOut(result.getString(3));
/*                nurseAllocationModel.setNursesId(result.getInt(4));
                nurseAllocationModel.setDoctorsId(result.getInt(5));
                nurseAllocationModel.setPatientId(result.getInt(6));*/
               /* nurseAllocationModel.setNurses(new NursesDao().getNurseById(result.getInt("id")));
                nurseAllocationModel.setPatient(new PatientDao().getPatientById(result.getInt("id")));
                nurseAllocationModel.setDoctors(new DoctorsDao().getDoctorById(result.getInt("id")));*/
                NursesDao nursesDao = new NursesDao();
                DoctorsDao doctorsDao = new DoctorsDao();
                PatientDao patientDao = new PatientDao();
                nurseAllocationModel.setNurses(nursesDao.getNurseById(result.getInt(4)));
                nurseAllocationModel.setDoctors(doctorsDao.getDoctorById(result.getInt(5)));
                nurseAllocationModel.setPatient(patientDao.getPatientById(result.getInt(6)));
                nurseAllocationModels.add(nurseAllocationModel);
                nurseAllocationModel.toString();
            }
            return nurseAllocationModels;
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
        return nurseAllocationModels;
    }

}
