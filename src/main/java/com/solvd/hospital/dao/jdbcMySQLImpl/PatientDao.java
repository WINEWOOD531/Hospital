package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.IPatientDao;
import com.solvd.hospital.models.PatientModel;
import com.solvd.hospital.models.PersonModel;
import com.solvd.hospital.utility.connection.DataBaseConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDao implements IPatientDao {

    private static final Logger LOGGER = LogManager.getLogger(PatientDao.class);
    final String deleteStatementS = "DELETE FROM Patient WHERE id=?";
    final String getStatement = "SELECT * FROM Patient WHERE id=?";
    final String insertStatementS = "INSERT INTO Patient VALUES (?, ?, ?,?,?)";
    final String updateStatementS = "UPDATE Patient SET bloodGroup=? WHERE id=?";
    private static final String GET_ALL = "SELECT * FROM Patient";
    final String INNERJOIN = "SELECT Patient.id,Patient.age,Patient.bloodGroup,Patient.sex,person.id," +
            " person.firstName, person.lastName " +
            "FROM Patient INNER JOIN person ON Patient.Person_id = person.id";
    PreparedStatement statement = null;
    ResultSet result = null;

    @Override
    public void createPatient(PatientModel patientModel) {
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(insertStatementS);
            statement.setInt(1, patientModel.getId());
            statement.setInt(2, patientModel.getAge());
            statement.setString(3, patientModel.getBloodGroup());
            statement.setString(4, patientModel.getSex());
            statement.setInt(5, patientModel.getPersonId());
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
    public void updatePatient(PatientModel patientModel) {
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(updateStatementS);
            statement.setString(1, patientModel.getBloodGroup());
            statement.setInt(2, patientModel.getId());
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
    public void deletePatientById(PatientModel patientModel) {
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(deleteStatementS);
            statement.setInt(1, patientModel.getId());
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
    public PatientModel getPatientById(int id) {
        Connection dbConnect = DataBaseConnection.getConnection();
        PatientModel patientModel = new PatientModel();
        PersonModel personModel = new PersonModel();
        try {
            statement = dbConnect.prepareStatement(getStatement);
            statement.setInt(1, id);
            result = statement.executeQuery();
            while (result.next()) {
                patientModel.setId(result.getInt("id"));
                patientModel.setAge(result.getInt("age"));
                patientModel.setBloodGroup(result.getString("bloodGroup"));
                patientModel.setSex(result.getString("sex"));
                personModel.setPersonId(result.getInt(5));
                patientModel.setPerson(personModel);
                patientModel.toString();
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
        return patientModel;
    }


    public ArrayList<PatientModel> getAllPatients() {
        ArrayList<PatientModel> patientModels = new ArrayList<>();
        Connection dbConnect = DataBaseConnection.getConnection();
        PersonModel personModel = new PersonModel();
        try {
            statement = dbConnect.prepareStatement(GET_ALL);
            result = statement.executeQuery();
            while (result.next()) {
                PatientModel patientModel = new PatientModel();
                patientModel.setId(result.getInt("id"));
                patientModel.setAge(result.getInt("age"));
                patientModel.setBloodGroup(result.getString("bloodGroup"));
                patientModel.setSex(result.getString("sex"));
                //patientModel.setPerson(new PersonDao().getPersonById(result.getInt(5)));
                PersonDao personDao = new PersonDao();
                patientModel.setPerson(personDao.getPersonById(result.getInt(5)));
                patientModels.add(patientModel);
                patientModel.toString();
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
        return patientModels;
    }

    public List<PatientModel> getAllPatientsJoinPerson() {
        ArrayList<PatientModel> patientModels = new ArrayList<>();
        Connection dbConnect = DataBaseConnection.getConnection();
        PersonModel personModel = new PersonModel();
        try {
            statement = dbConnect.prepareStatement(INNERJOIN);
            result = statement.executeQuery();
            while (result.next()) {
                PatientModel patientModel = new PatientModel();
                patientModel.setId(result.getInt("id"));
                patientModel.setAge(result.getInt("age"));
                patientModel.setBloodGroup(result.getString("bloodGroup"));
                patientModel.setSex(result.getString("sex"));
/*                patientModel.setPersonId(result.getInt("person.id"));
                patientModel.setFirstName(result.getString("person.firstName"));
                patientModel.setLastName(result.getString("person.lastName"));*/
                PersonDao personDao = new PersonDao();
                patientModel.setPerson(personDao.getPersonById(result.getInt("person.id")));
                patientModels.add(patientModel);
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
        return patientModels;
    }


}
