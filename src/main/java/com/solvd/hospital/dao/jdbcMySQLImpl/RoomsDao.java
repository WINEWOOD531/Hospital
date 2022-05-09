package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.IRoomsDao;
import com.solvd.hospital.models.RoomsModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ResourceBundle;

public class RoomsDao implements IRoomsDao {

    private static final Logger LOGGER = LogManager.getLogger(RoomsDao.class);

    ResourceBundle resource = ResourceBundle.getBundle("db");
    String url = resource.getString("db.url");
    String user = resource.getString("db.username");
    String pass = resource.getString("db.password");

    @Override
    public void createRoom(int id, String roomNumber, String departmentName, String dateIn, String dateOut, int patientId) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("INSERT INTO\n" +
                    " rooms VALUES (?, ?, ?,?,?,?);");
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
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("UPDATE rooms SET dateIn=? WHERE id=?");
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
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("DELETE FROM rooms WHERE id=?");
            stmt.setInt(1, id);

            int i = stmt.executeUpdate();
            LOGGER.info(i + " records deleted");

        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public RoomsModel getRoomByDepartmentName(String name) {

        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("SELECT * " +
                    "FROM rooms WHERE departmentName= ? ");
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                LOGGER.info("Id: " + rs.getInt(1) + "\n"
                        + "\nRoom Number: " + rs.getString(2) +
                        "\nDepartment name: " + rs.getString(3) +
                        "\nDate In: " + rs.getString(4) +
                        "\nDate Out: " + rs.getString(5) +
                        "\nPatient Id: " + rs.getInt(6));
            }
        } catch (Exception e) {
            LOGGER.info(e);
        }
        return null;
    }
}
