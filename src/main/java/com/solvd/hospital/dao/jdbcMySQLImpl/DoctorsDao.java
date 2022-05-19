package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.IDoctorsDao;
import com.solvd.hospital.models.DoctorsModel;
import com.solvd.hospital.models.PersonModel;
import com.solvd.hospital.utility.connection.DataBaseConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DoctorsDao implements IDoctorsDao {

    private static final Logger LOGGER = LogManager.getLogger(DoctorsDao.class);
    final String deleteStatementS = "DELETE FROM Doctors WHERE id = ?";
    final String getStatement = "SELECT * FROM Doctors WHERE id=?";
    final String insertStatementS = "INSERT INTO Doctors VALUES (?, ?, ?)";
    final String updateStatementS = "UPDATE Doctors SET availaibleDate=? WHERE id=?";
    private static final String GET_ALL = "SELECT * FROM Doctors";
    final String INNERJOIN = "SELECT doctors.id,doctors.availaibleDate,person.id, person.firstName, person.lastName " +
            "FROM doctors INNER JOIN person ON doctors.Person_id = person.id";
    PreparedStatement statement = null;
    ResultSet result = null;
    PersonModel personModel = new PersonModel();

    @Override
    public void createDoctor(DoctorsModel doctorsModel) {
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(insertStatementS);
            statement.setInt(1, doctorsModel.getId());
            statement.setString(2, doctorsModel.getAvailableDate());
            statement.setInt(3, doctorsModel.getPersonId());
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
    public void updateDoctor(DoctorsModel doctorsModel) {
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(updateStatementS);
            statement.setString(1, doctorsModel.getAvailableDate());
            statement.setInt(2, doctorsModel.getId());
            int i = statement.executeUpdate();
            LOGGER.info(i + " records updated");
        } catch (SQLException e) {
            LOGGER.error("ERROR UPDATE DOCTORS " + e.getMessage());
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
    public void deleteDoctorById(DoctorsModel doctorsModel) {
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(deleteStatementS);
            statement.setInt(1, doctorsModel.getId());
            int i = statement.executeUpdate();
            LOGGER.info(i + " records deleted");
            //statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("ERROR DELETE Doctor WITH ID " + e.getMessage());
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
    public DoctorsModel getDoctorById(int id) {
        Connection con = DataBaseConnection.getConnection();
        DoctorsModel doctors = new DoctorsModel();
        try {
            statement = con.prepareStatement(getStatement);
            statement.setInt(1, id);
            result = statement.executeQuery();
            while (result.next()) {
                doctors.setId(result.getInt("id"));
                doctors.setAvailableDate(result.getString("availaibleDate"));
                doctors.setPersonId(result.getInt("Person_id"));
                doctors.toString();
            }
        } catch (Exception e) {
            LOGGER.info(e);
        } finally {
            try {
                DataBaseConnection.close(con);
                statement.close();
                result.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return doctors;
    }

    public List<DoctorsModel> getALLDoctors() {
        ArrayList<DoctorsModel> doctorsModels = new ArrayList<DoctorsModel>();
        Connection con = DataBaseConnection.getConnection();
        try {
            statement = con.prepareStatement(GET_ALL);
            result = statement.executeQuery();
            while (result.next()) {
                DoctorsModel doctors = new DoctorsModel();
                doctors.setId(result.getInt("id"));
                doctors.setAvailableDate(result.getString("availaibleDate"));
                doctors.setPersonId(result.getInt("Person_id"));
                doctorsModels.add(doctors);
            }
        } catch (Exception e) {
            LOGGER.info(e);
        } finally {
            try {
                DataBaseConnection.close(con);
                statement.close();
                result.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return doctorsModels;
    }

/*    public List<DoctorsModel> getALLDoctorsJoinPerson() {
        ArrayList<DoctorsModel> doctorsModels = new ArrayList<DoctorsModel>();
        Connection con = DataBaseConnection.getConnection();
        try {
            statement = con.prepareStatement(INNERJOIN);
            result = statement.executeQuery();
            while (result.next()) {
                DoctorsModel doctors = new DoctorsModel();
                doctors.setId(result.getInt("id"));
                doctors.setAvailableDate(result.getString("availaibleDate"));
                doctors.setPersonId(result.getInt("person.id"));
                doctors.setFirstName(result.getString("person.firstName"));
                doctors.setLastName(result.getString("person.lastName"));
                doctorsModels.add(doctors);
            }
        } catch (Exception e) {
            LOGGER.info(e);
        } finally {
            try {
                DataBaseConnection.close(con);
                statement.close();
                result.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return doctorsModels;
    }*/

}
