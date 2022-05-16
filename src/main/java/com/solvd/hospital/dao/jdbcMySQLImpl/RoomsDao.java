package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.IRoomsDao;
import com.solvd.hospital.models.PatientModel;
import com.solvd.hospital.models.RoomsModel;
import com.solvd.hospital.utility.connection.DataBaseConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;

public class RoomsDao implements IRoomsDao {

    private static final Logger LOGGER = LogManager.getLogger(RoomsDao.class);

    final String deleteStatementS = "DELETE FROM rooms WHERE id=?";
    final String getStatement = "SELECT * FROM rooms WHERE departmentName= ?";
    final String insertStatementS = "INSERT INTO rooms VALUES (?, ?, ?,?,?,?)";
    final String updateStatementS = "UPDATE rooms SET dateIn=? WHERE id=?";
    private static final String GET_ALL = "SELECT * FROM rooms";
    final String INNERJOIN = "SELECT rooms.id,rooms.roomNumber,rooms.departmentName,rooms.dateIn,rooms.dateOut," +
            "patient.id,patient.age,patient.bloodGroup,patient.sex FROM hospital.rooms  INNER JOIN hospital.patient ON" +
            " rooms.Patient_id = patient.id";
    PreparedStatement statement = null;
    ResultSet result = null;

    @Override
    public void createRoom(RoomsModel roomsModel) {
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(insertStatementS);
            statement.setInt(1, roomsModel.getRoomsId());
            statement.setString(2, roomsModel.getRoomNumber());
            statement.setString(3, roomsModel.getDepartmentName());
            statement.setString(4, roomsModel.getDateIn());
            statement.setString(5, roomsModel.getDateOut());
            statement.setInt(6, roomsModel.getPatient().getId());
            int i = statement.executeUpdate();
            LOGGER.info(i + " records inserted");
        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void updateRoom(RoomsModel roomsModel) {
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(updateStatementS);
            statement.setString(1, roomsModel.getDateIn());
            statement.setInt(2, roomsModel.getRoomsId());
            int i = statement.executeUpdate();
            LOGGER.info(i + " records updated");
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
    }

    @Override
    public void deleteRoomById(RoomsModel roomsModel) {
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(deleteStatementS);
            statement.setInt(1, roomsModel.getRoomsId());
            int i = statement.executeUpdate();
            LOGGER.info(i + " records deleted");
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
    }

    @Override
    public ArrayList<RoomsModel> getRoomByDepartmentName(String name) {
        ArrayList<RoomsModel> roomsModels = new ArrayList<>();
        PatientModel patient = new PatientModel();
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(getStatement);
            statement.setString(1, name);
            result = statement.executeQuery();
            while (result.next()) {
                RoomsModel roomsModel = new RoomsModel();
                roomsModel.setId(result.getInt("id"));
                roomsModel.setRoomNumber(result.getString("roomNumber"));
                roomsModel.setDepartmentName(result.getString("departmentName"));
                roomsModel.setDateIn(result.getString("dateIn"));
                roomsModel.setDateOut(result.getString("dateOut"));
                roomsModel.setRoomsId(result.getInt("Patient_id"));
                roomsModels.add(roomsModel);
                roomsModel.toString();
            }
            LOGGER.info("ALL is OK!");
            return roomsModels;
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
        return null;
    }

    public ArrayList<RoomsModel> getAllRooms() {
        ArrayList<RoomsModel> roomsModels = new ArrayList<>();
        PatientModel patient = new PatientModel();
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(GET_ALL);
            result = statement.executeQuery();
            while (result.next()) {
                RoomsModel roomsModel = new RoomsModel();
                roomsModel.setId(result.getInt("id"));
                roomsModel.setRoomNumber(result.getString("roomNumber"));
                roomsModel.setDepartmentName(result.getString("departmentName"));
                roomsModel.setDateIn(result.getString("dateIn"));
                roomsModel.setDateOut(result.getString("dateOut"));
                roomsModel.setRoomsId(result.getInt("Patient_id"));
                roomsModels.add(roomsModel);
                roomsModel.toString();
            }
            LOGGER.info("ALL is OK!");
            return roomsModels;
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
        return null;
    }

    public ArrayList<RoomsModel> getAllRoomsJoinPatient() {
        ArrayList<RoomsModel> roomsModels = new ArrayList<>();
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(INNERJOIN);
            result = statement.executeQuery();
            while (result.next()) {
                RoomsModel roomsModel = new RoomsModel();
                roomsModel.setId(result.getInt("id"));
                roomsModel.setRoomNumber(result.getString("roomNumber"));
                roomsModel.setDepartmentName(result.getString("departmentName"));
                roomsModel.setDateIn(result.getString("dateIn"));
                roomsModel.setDateOut(result.getString("dateOut"));
                roomsModel.setRoomsId(result.getInt("patient.id"));
                roomsModel.setAge(result.getInt("patient.age"));
                roomsModel.setBloodGroup(result.getString("patient.bloodGroup"));
                roomsModel.setSex(result.getString("patient.sex"));
                roomsModels.add(roomsModel);
            }
            LOGGER.info("ALL is OK!");
            return roomsModels;
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
        return null;
    }

}
