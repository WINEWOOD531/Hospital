package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.IDoctorsDao;
import com.solvd.hospital.models.DoctorsModel;
import com.solvd.hospital.utility.parsers.DataBaseConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DoctorsDao implements IDoctorsDao {

    private static final Logger LOGGER = LogManager.getLogger(DoctorsDao.class);
    final String deleteStatementS = "DELETE FROM Doctors WHERE id = ?";
    final String getStatement = "SELECT * FROM Doctors WHERE availaibleDate LIKE ? ESCAPE '!'";
    final String insertStatementS = "INSERT INTO Doctors VALUES (?, ?, ?)";
    final String updateStatementS = "UPDATE Doctors SET availaibleDate=? WHERE id=?";

    @Override
    public void createDoctor(DoctorsModel doctorsModel) {
        try (Connection dbConnect = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = dbConnect.prepareStatement(insertStatementS);
            stmt.setInt(1, doctorsModel.getId());
            stmt.setString(2, doctorsModel.getAvailableDate());
            stmt.setInt(3, doctorsModel.getPersonId());
            int i = stmt.executeUpdate();
            LOGGER.info(i + " records inserted");
        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void updateDoctor(String availaibleDate, int id) {
        Connection dbConnect = DataBaseConnection.getConnection();
        PreparedStatement updateStatement = null;
        int x = 0;
        try {
            updateStatement = dbConnect.prepareStatement(updateStatementS);
            updateStatement.setString(1, availaibleDate);
            updateStatement.setInt(2, id);
            updateStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("ERROR UPDATE CLIENTS " + e.getMessage());
            x = 1;
        } finally {
            DataBaseConnection.close(updateStatement);
            DataBaseConnection.close(dbConnect);
            if (x == 0) {
                LOGGER.info("SUCCESS CLOSE");
            } else
                LOGGER.info("FAIL CLOSE");
        }

    }

    @Override
    public void deleteDoctorById(int id) {
        int x = 0;
        Connection dbConnect = DataBaseConnection.getConnection();
        PreparedStatement deleteStatement = null;
        try {
            deleteStatement = dbConnect.prepareStatement(deleteStatementS);
            deleteStatement.setInt(1, id);
            deleteStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("ERROR DELETE Doctor WITH ID " + e.getMessage());
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
    public List<DoctorsModel> getDoctorByDate(String date) {
        ArrayList<DoctorsModel> doctorsModels = new ArrayList<DoctorsModel>();
        try (Connection con = DataBaseConnection.getConnection()) {
            PreparedStatement statement = con.prepareStatement(getStatement);
            statement.setString(1, date + "%");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt("Person_id");
                String availaibleDate = result.getString("availaibleDate");
                int personId = result.getInt("id");
                DoctorsModel doctors = new DoctorsModel(id, availaibleDate, personId);
                doctorsModels.add(doctors);
                doctors.toString();
            }
            LOGGER.info("ALL is OK!");
            return doctorsModels;
        } catch (Exception e) {
            LOGGER.info(e);
        }
        return null;
    }

}
