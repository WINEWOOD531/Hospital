package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.INursesDao;
import com.solvd.hospital.models.NursesModel;
import com.solvd.hospital.utility.parsers.DataBaseConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NursesDao implements INursesDao {

    private static final Logger LOGGER = LogManager.getLogger(NursesDao.class);

    final String deleteStatementS = "DELETE FROM Nurses WHERE id=?";
    final String getStatement = "SELECT * FROM Nurses WHERE workExperience > ?";
    final String insertStatementS = "INSERT INTO Nurses VALUES (?, ?,?)";
    final String updateStatementS = "UPDATE Nurses SET workExperience=? WHERE id=?";

    @Override
    public void createNurse(int id, int personId, int workExperience) {
        try (Connection dbConnect = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = dbConnect.prepareStatement(insertStatementS);
            stmt.setInt(1, id);
            stmt.setInt(2, personId);
            stmt.setInt(3, workExperience);
            int i = stmt.executeUpdate();
            LOGGER.info(i + " records inserted");
        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void updateNurse(int workExperience, int id) {
        try (Connection dbConnect = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = dbConnect.prepareStatement(updateStatementS);
            stmt.setInt(1, workExperience);
            stmt.setInt(2, id);
            int i = stmt.executeUpdate();
            LOGGER.info(i + " records updated");
        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void deleteNurseById(int id) {
        int x = 0;
        Connection dbConnect = DataBaseConnection.getConnection();
        PreparedStatement deleteStatement = null;
        try {
            deleteStatement = dbConnect.prepareStatement(deleteStatementS);
            deleteStatement.setInt(1, id);
            int i = deleteStatement.executeUpdate();
            LOGGER.info(i + " records deleted");
        } catch (SQLException e) {
            LOGGER.error("ERROR DELETE Nurses WITH ID " + e.getMessage());
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
    public List<NursesModel> getNurseByIdWorkExperience(int workExperience) {
        try (Connection dbConnect = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = dbConnect.prepareStatement(getStatement);
            stmt.setInt(1, workExperience);
            ResultSet rs = stmt.executeQuery();
            ArrayList<NursesModel> nursesModels = new ArrayList<>();
            while (rs.next()) {
                int personId = rs.getInt(2);
                int id = rs.getInt(1);
                workExperience = rs.getInt(3);
                NursesModel nursesModel = new NursesModel(personId, id, workExperience);
                nursesModels.add(nursesModel);
                nursesModel.toString();
            }
            LOGGER.info("ALL is OK!");
            return nursesModels;
        } catch (Exception e) {
            LOGGER.info(e);
        }
        return null;
    }


}
