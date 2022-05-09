package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.IAppointmentDao;
import com.solvd.hospital.models.AppointmentModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ResourceBundle;

public class AppointmentDao implements IAppointmentDao {

    private static final Logger LOGGER = LogManager.getLogger(AppointmentDao.class);

    ResourceBundle resource = ResourceBundle.getBundle("db");
    String url = resource.getString("db.url");
    String user = resource.getString("db.username");
    String pass = resource.getString("db.password");

    @Override
    public void createAppointment(int id, String appointmentDate, int doctorsId, int patientsId) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("INSERT INTO\n" +
                    " appointment VALUES (?, ?, ?,?);");
            stmt.setInt(1, id);
            stmt.setString(2, appointmentDate);
            stmt.setInt(3, doctorsId);
            stmt.setInt(4, patientsId);

            int i = stmt.executeUpdate();
            LOGGER.info(i + " records inserted");

        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void updateAppointment(String appointmentDate, int id) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("UPDATE appointment SET appointmentDate=? WHERE id=?");
            stmt.setString(1, appointmentDate);
            stmt.setInt(2, id);

            int i = stmt.executeUpdate();
            LOGGER.info(i + " records updated");

        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void deleteAppointmentById(int id) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("DELETE FROM appointment WHERE id=?");
            stmt.setInt(1, id);

            int i = stmt.executeUpdate();
            LOGGER.info(i + " records deleted");

        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public AppointmentModel getAppointmentByDoctorId(int id) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM appointment WHERE Doctors_id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                LOGGER.info("\nId: " + rs.getInt(1) + "\nAppointment Date: " + rs.getString(2) +
                        "\nDoctors_id:  " + rs.getString(3) +
                        "\nPatient_id:  " + rs.getInt(4));
            }
        } catch (Exception e) {
            LOGGER.info(e);
        }
        return null;
    }
}
