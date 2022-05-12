package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.IAppointmentDao;
import com.solvd.hospital.models.AppointmentModel;
import com.solvd.hospital.models.DoctorsModel;
import com.solvd.hospital.models.PatientModel;
import com.solvd.hospital.utility.parsers.DataBaseConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AppointmentDao implements IAppointmentDao {

    private static final Logger LOGGER = LogManager.getLogger(AppointmentDao.class);
    final String deleteStatementS = "DELETE FROM appointment WHERE id=?";
    final String getStatement = "SELECT * FROM appointment WHERE Doctors_id = ?";
    final String insertStatementS = "INSERT INTO appointment VALUES (?, ?, ?,?)";
    final String updateStatementS = "UPDATE appointment SET appointmentDate=? WHERE id=?";

    @Override
    public void createAppointment(int id, String appointmentDate, int doctorsModelId, int patientModelId) {
        try (Connection dbConnect = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = dbConnect.prepareStatement(insertStatementS);
            stmt.setInt(1, id);
            stmt.setString(2, appointmentDate);
            stmt.setInt(3, doctorsModelId);
            stmt.setInt(4, patientModelId);
            int i = stmt.executeUpdate();
            LOGGER.info(i + " records inserted");
        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void updateAppointment(String appointmentDate, int id) {
        try (Connection dbConnect = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = dbConnect.prepareStatement(updateStatementS);
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
        int x = 0;
        Connection dbConnect = DataBaseConnection.getConnection();
        PreparedStatement deleteStatement = null;
        try {
            deleteStatement = dbConnect.prepareStatement(deleteStatementS);
            deleteStatement.setInt(1, id);
            int i = deleteStatement.executeUpdate();
            LOGGER.info(i + " records deleted");
        } catch (SQLException e) {
            LOGGER.error("ERROR DELETE Appointment WITH ID " + e.getMessage());
            x = 1;
        } finally {
            DataBaseConnection.close(deleteStatement);
            DataBaseConnection.close(dbConnect);
            if (x == 0) {
                LOGGER.info("SUCCESS CLOSE");
            } else
                LOGGER.info("FAIL CLOSE");
        }
    }

    @Override
    public List<AppointmentModel> getAppointmentByDoctorId(int id) {
        try (Connection con = DataBaseConnection.getConnection()) {
            DoctorsModel doctors = new DoctorsModel();
            PatientModel patient = new PatientModel();
            PreparedStatement statement = con.prepareStatement(getStatement);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            ArrayList<AppointmentModel> appointmentModels = new ArrayList<AppointmentModel>();
            while (result.next()) {
                id = result.getInt(1);
                String appointmentDate = result.getString(2);
                int doctorsId = result.getInt(3);
                int patientId = result.getInt(4);
                AppointmentModel appointmentModel = new AppointmentModel(id, appointmentDate, doctors, patient);
                appointmentModels.add(appointmentModel);
                appointmentModel.toString();
            }
            LOGGER.info("ALL is OK!");
            return appointmentModels;
        } catch (Exception e) {
            LOGGER.info(e);
        }
        return null;
    }
}
