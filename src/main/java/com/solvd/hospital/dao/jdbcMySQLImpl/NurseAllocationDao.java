package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.INurseAllocationDao;
import com.solvd.hospital.models.NurseAllocationModel;
import com.solvd.hospital.models.NursesModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ResourceBundle;

public class NurseAllocationDao implements INurseAllocationDao {

    private static final Logger LOGGER = LogManager.getLogger(NurseAllocationDao.class);

    ResourceBundle resource = ResourceBundle.getBundle("db");
    String url = resource.getString("db.url");
    String user = resource.getString("db.username");
    String pass = resource.getString("db.password");

    @Override
    public void createNurseAllocation(int id, String dateIn, String dateOut, int nursesId, int doctorsId, int personId) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("INSERT INTO\n" +
                    " nurseallocation VALUES (?, ?, ?,?,?,?);");
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
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("UPDATE nurseallocation SET dateIn=? WHERE id=?");
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
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("DELETE FROM nurseallocation WHERE id=?");
            stmt.setInt(1, id);

            int i = stmt.executeUpdate();
            LOGGER.info(i + " records deleted");

        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public NurseAllocationModel getNurseAllocationById(int id) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM nurseallocation WHERE Nurses_id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                LOGGER.info("\nId:" + rs.getInt(1) + "\nDate In: " + rs.getString(2) +
                        "\nDate Out " + rs.getString(3) + "\nNurses Id: " + rs.getString(4) +
                        "\nDoctor id: " + rs.getString(5) + "\nPerson Id: " + rs.getString(6));
            }
        } catch (Exception e) {
            LOGGER.info(e);
        }
        return null;
    }


}
