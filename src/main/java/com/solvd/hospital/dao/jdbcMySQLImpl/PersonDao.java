package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.IPersonDao;
import com.solvd.hospital.models.PatientModel;
import com.solvd.hospital.models.PersonModel;
import com.solvd.hospital.utility.connection.DataBaseConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDao implements IPersonDao {

    private static final Logger LOGGER = LogManager.getLogger(PersonDao.class);

    final String deleteStatementS = "DELETE FROM person WHERE id=?";
    final String getStatement = "SELECT * FROM person WHERE firstName = ?";
    final String insertStatementS = "INSERT INTO person VALUES (?, ?,?,?)";
    final String updateStatementS = "UPDATE person SET phoneNumber=? WHERE id=?";
    private static final String GET_ALL = "SELECT * FROM person";
    PreparedStatement statement = null;
    ResultSet result = null;

    @Override
    public void createPerson(PersonModel personModel) {
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(insertStatementS);
            statement.setInt(1, personModel.getPersonId());
            statement.setString(2, personModel.getFirstName());
            statement.setString(3, personModel.getLastName());
            statement.setString(4, personModel.getPhoneNumber());
            int i = statement.executeUpdate();
            LOGGER.info(i + " records inserted");
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
    public void updatePerson(PersonModel personModel) {
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(updateStatementS);
            statement.setString(1, personModel.getPhoneNumber());
            statement.setInt(2, personModel.getPersonId());
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
    public void deletePersonById(PersonModel personModel) {
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(deleteStatementS);
            statement.setInt(1, personModel.getPersonId());
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
    public List<PersonModel> getPersonByName(String name) {
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(getStatement);
            statement.setString(1, name);
            result = statement.executeQuery();
            ArrayList<PersonModel> personModels = new ArrayList<>();
            while (result.next()) {
                PersonModel personModel = new PatientModel();
                personModel.setPersonId(result.getInt(1));
                personModel.setFirstName(result.getString(2));
                personModel.setLastName(result.getString(3));
                personModel.setPhoneNumber(result.getString(4));
                personModels.add(personModel);
                personModel.toString();
            }
            LOGGER.info("ALL is OK!");
            return personModels;
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

    public ArrayList<PersonModel> getAllPersons() {
        ArrayList<PersonModel> personModels = new ArrayList<>();
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(GET_ALL);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                PersonModel personModel = new PatientModel();
                personModel.setPersonId(result.getInt(1));
                personModel.setFirstName(result.getString(2));
                personModel.setLastName(result.getString(3));
                personModel.setPhoneNumber(result.getString(4));
                personModels.add(personModel);
                personModel.toString();
            }
            LOGGER.info("ALL is OK!");
            return personModels;
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
