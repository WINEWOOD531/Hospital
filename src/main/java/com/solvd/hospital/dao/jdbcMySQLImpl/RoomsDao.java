package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.IRoomsDao;
import com.solvd.hospital.models.PatientModel;
import com.solvd.hospital.models.RoomsModel;
import com.solvd.hospital.utility.parsers.DataBaseConnection;
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

    @Override
    public void createRoom(int id, String roomNumber, String departmentName, String dateIn,
                           String dateOut, int patientId) {
        try (Connection dbConnect = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = dbConnect.prepareStatement(insertStatementS);
            stmt.setInt(1, id);
            stmt.setString(2, roomNumber);
            stmt.setString(3, departmentName);
            stmt.setString(4, dateIn);
            stmt.setString(5, dateOut);
            stmt.setInt(6, patientId);
            int i = stmt.executeUpdate();
            LOGGER.info(i + " records inserted");
        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void updateRoom(String dateIn, int id) {
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
    public void deleteRoomById(int id) {
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
    public ArrayList<RoomsModel> getRoomByDepartmentName(String name) {
        ArrayList<RoomsModel>roomsModels=new ArrayList<>();
        PatientModel patient = new PatientModel();
        try (Connection dbConnect = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = dbConnect.prepareStatement(getStatement);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String roomNumber = rs.getString(2);
                name = rs.getString(3);
                String dateIn = rs.getString(4);
                String dateOut = rs.getString(5);
                int patientId = rs.getInt(6);
                RoomsModel roomsModel= new RoomsModel(id,roomNumber,name,dateIn,dateOut,patient);
                roomsModels.add(roomsModel);
                roomsModel.toString();
            }
            LOGGER.info("ALL is OK!");
            return roomsModels;
        } catch (Exception e) {
            LOGGER.info(e);
        }
        return null;
    }
}
