package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.IAppointmentDao;
import com.solvd.hospital.models.AppointmentModel;
import com.solvd.hospital.models.DoctorsModel;
import com.solvd.hospital.models.PatientModel;
import com.solvd.hospital.models.PersonModel;
import com.solvd.hospital.utility.connection.DataBaseConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDao implements IAppointmentDao {

    private static final Logger LOGGER = LogManager.getLogger(AppointmentDao.class);
    final String deleteStatementS = "DELETE FROM appointment WHERE id=?";
    final String getStatement = "SELECT * FROM appointment WHERE id=?";
    final String insertStatementS = "INSERT INTO appointment VALUES (?, ?, ?,?)";
    final String updateStatementS = "UPDATE appointment SET appointmentDate=? WHERE id=?";
    private static final String GET_ALL = "SELECT * FROM appointment";
    PreparedStatement statement = null;
    ResultSet result = null;

    @Override
    public void createAppointment(AppointmentModel appointmentModel) {
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(insertStatementS);
            statement.setInt(1, appointmentModel.getId());
            statement.setString(2, appointmentModel.getAppointmentDate());
            statement.setInt(3, appointmentModel.getDoctorsId());
            statement.setInt(4, appointmentModel.getPatientId());
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
    public void updateAppointment(AppointmentModel appointmentModel) {
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(updateStatementS);
            statement.setString(1, appointmentModel.getAppointmentDate());
            statement.setInt(2, appointmentModel.getId());
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
    public void deleteAppointmentById(AppointmentModel appointmentModel) {
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(deleteStatementS);
            statement.setInt(1, appointmentModel.getId());
            int i = statement.executeUpdate();
            LOGGER.info(i + " records deleted");
        } catch (SQLException e) {
            LOGGER.error("ERROR DELETE Appointment WITH ID " + e.getMessage());
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
    public AppointmentModel getAppointmentById(int id) {
        Connection dbConnect = DataBaseConnection.getConnection();
        AppointmentModel appointmentModel = new AppointmentModel();
        DoctorsModel doctorsModel = new DoctorsModel();
        PatientModel patientModel = new PatientModel();
        try {
            statement = dbConnect.prepareStatement(getStatement);
            statement.setInt(1, id);
            result = statement.executeQuery();
            while (result.next()) {
                appointmentModel.setId(result.getInt(1));
                appointmentModel.setAppointmentDate(result.getString(2));
                doctorsModel.setId(result.getInt("id"));
                patientModel.setId(result.getInt("id"));
                appointmentModel.setDoctors(doctorsModel);
                appointmentModel.setPatient(patientModel);
               /* appointmentModel.setDoctors(new DoctorsDao().getDoctorById(result.getInt(3)));
                appointmentModel.setPatient(new PatientDao().getPatientById(result.getInt(4)));*/
                appointmentModel.toString();
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
        return appointmentModel;
    }

    public List<AppointmentModel> getAllAppointments() {
        Connection dbConnect = DataBaseConnection.getConnection();
        ArrayList<AppointmentModel> appointmentModels = new ArrayList<AppointmentModel>();
        DoctorsModel doctorsModel = new DoctorsModel();
        PatientModel patientModel = new PatientModel();
        try {
            statement = dbConnect.prepareStatement(GET_ALL);
            result = statement.executeQuery();
            while (result.next()) {
                AppointmentModel appointmentModel = new AppointmentModel();
                appointmentModel.setId(result.getInt(1));
                appointmentModel.setAppointmentDate(result.getString(2));
/*                doctorsModel.setId(result.getInt("id"));
                patientModel.setId(result.getInt("id"));
                appointmentModel.setDoctors(doctorsModel);
                appointmentModel.setPatient(patientModel);*/
                DoctorsDao doctorsDao=new DoctorsDao();
                //appointmentModel.setDoctors(new DoctorsDao().getDoctorById(result.getInt(3)));
                appointmentModel.setDoctors(doctorsDao.getDoctorById(result.getInt(3)));
                //appointmentModel.setPatient(new PatientDao().getPatientById(result.getInt(4)));
                PatientDao patientDao= new PatientDao();
                appointmentModel.setPatient(patientDao.getPatientById(result.getInt(4)));
                appointmentModels.add(appointmentModel);
                appointmentModel.toString();
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
        return appointmentModels;
    }
}
