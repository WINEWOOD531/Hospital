package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.INursesDao;
import com.solvd.hospital.models.NursesModel;
import com.solvd.hospital.models.PersonModel;
import com.solvd.hospital.utility.connection.DataBaseConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NursesDao implements INursesDao {

    private static final Logger LOGGER = LogManager.getLogger(NursesDao.class);

    final String deleteStatementS = "DELETE FROM Nurses WHERE id=?";
    final String getStatement = "SELECT * FROM Nurses WHERE id=?";
    final String insertStatementS = "INSERT INTO Nurses VALUES (?, ?,?)";
    final String updateStatementS = "UPDATE Nurses SET workExperience=? WHERE id=?";
    final String INNERJOIN = "SELECT Nurses.id,Nurses.workExperience,person.id, person.firstName," +
            " person.lastName FROM Nurses INNER JOIN person ON Nurses.Person_id = person.id";
    private static final String GET_ALL = "SELECT * FROM Nurses";
    PreparedStatement statement = null;
    ResultSet result = null;

    @Override
    public void createNurse(NursesModel nursesModel) {
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(insertStatementS);
            statement.setInt(1, nursesModel.getId());
            statement.setInt(2, nursesModel.getPersonId());
            statement.setInt(3, nursesModel.getWorkExperience());
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
    public void updateNurse(NursesModel nursesModel) {
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(updateStatementS);
            statement.setInt(1, nursesModel.getWorkExperience());
            statement.setInt(2, nursesModel.getId());
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
    public void deleteNurseById(NursesModel nursesModel) {
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(deleteStatementS);
            statement.setInt(1, nursesModel.getId());
            int i = statement.executeUpdate();
            LOGGER.info(i + " records deleted");
        } catch (SQLException e) {
            LOGGER.error("ERROR DELETE Nurses WITH ID " + e.getMessage());
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
    public NursesModel getNurseById(int id) {
        Connection dbConnect = DataBaseConnection.getConnection();
        NursesModel nursesModel = new NursesModel();
        PersonModel personModel = new PersonModel();
        try {
            statement = dbConnect.prepareStatement(getStatement);
            statement.setInt(1, id);
            result = statement.executeQuery();
            while (result.next()) {
                nursesModel.setId(result.getInt("id"));
                personModel.setPersonId(result.getInt(2));
                nursesModel.setPersonModel(personModel);
                nursesModel.setWorkExperience(result.getInt("workExperience"));
                nursesModel.toString();
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
        return nursesModel;
    }


    public List<NursesModel> getAllNurses() {
        ArrayList<NursesModel> nursesModels = new ArrayList<>();
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(GET_ALL);
            result = statement.executeQuery();
            while (result.next()) {
                NursesModel nursesModel = new NursesModel();
                nursesModel.setId(result.getInt("id"));
                PersonDao personDao = new PersonDao();
                nursesModel.setPersonModel(personDao.getPersonById(result.getInt(2)));
                //nursesModel.setPersonModel(new PersonDao().getPersonById(result.getInt(2)));
                nursesModel.setWorkExperience(result.getInt("workExperience"));
                /*nursesModel.setPersonId(result.getInt("Person_id"));*/
                nursesModels.add(nursesModel);
                nursesModel.toString();
            }
            return nursesModels;
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
        return nursesModels;
    }

    public List<NursesModel> getAllNursesJoinPerson() {
        ArrayList<NursesModel> nursesModels = new ArrayList<>();
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(INNERJOIN);
            result = statement.executeQuery();
            while (result.next()) {
                NursesModel nursesModel = new NursesModel();
                nursesModel.setId(result.getInt("id"));
                PersonDao personDao = new PersonDao();
                nursesModel.setPersonModel(personDao.getPersonById(result.getInt("person.id")));
                nursesModel.setWorkExperience(result.getInt("workExperience"));
                //nursesModel.setPersonId(result.getInt("person.id"));
/*                nursesModel.setFirstName(result.getString("person.firstName"));
                nursesModel.setLastName(result.getString("person.lastName"));*/
                nursesModels.add(nursesModel);
                nursesModel.toString();
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
        return nursesModels;
    }
}
