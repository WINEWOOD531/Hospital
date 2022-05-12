package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.IPersonDao;
import com.solvd.hospital.models.PatientModel;
import com.solvd.hospital.models.PersonModel;
import com.solvd.hospital.utility.parsers.DataBaseConnection;
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

    @Override
    public void createPerson(int id, String firstName, String lastName, String phoneNumber) {
        try (Connection dbConnect = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = dbConnect.prepareStatement(insertStatementS);
            stmt.setInt(1, id);
            stmt.setString(2, firstName);
            stmt.setString(3, lastName);
            stmt.setString(4, phoneNumber);
            int i = stmt.executeUpdate();
            LOGGER.info(i + " records inserted");
        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void updatePerson(String phoneNumber, int id) {
        try (Connection dbConnect = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = dbConnect.prepareStatement(updateStatementS);
            stmt.setString(1, phoneNumber);
            stmt.setInt(2, id);
            int i = stmt.executeUpdate();
            LOGGER.info(i + " records updated");
        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void deletePersonById(int id) {
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
    public List<PersonModel> getPersonByName(String name) {
        try (Connection dbConnect = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = dbConnect.prepareStatement(getStatement);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            ArrayList<PersonModel> personModels = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt(1);
                name = rs.getString(2);
                String lastName = rs.getString(3);
                String phoneNumber = rs.getString(4);
                PersonModel personModel = new PatientModel();
                personModels.add(personModel);
                personModel.toString();
            }
            LOGGER.info("ALL is OK!");
            return personModels;
        } catch (Exception e) {
            LOGGER.info(e);
        }
        return null;
    }


}
