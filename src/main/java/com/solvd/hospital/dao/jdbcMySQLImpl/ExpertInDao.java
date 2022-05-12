package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.IExpertInDao;
import com.solvd.hospital.models.DoctorsModel;
import com.solvd.hospital.models.ExpertInModel;
import com.solvd.hospital.models.SpecializationModel;
import com.solvd.hospital.utility.parsers.DataBaseConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ExpertInDao implements IExpertInDao {

    private static final Logger LOGGER = LogManager.getLogger(ExpertInDao.class);

    final String deleteStatementS = "DELETE FROM ExpertIn WHERE id=?";
    final String getStatement = "SELECT * FROM ExpertIn WHERE Specialization_id = ?";
    final String insertStatementS = "INSERT INTO ExpertIn VALUES (?, ?,?)";
    final String updateStatementS = "UPDATE ExpertIn SET Specialization_id=? WHERE id=?";


    @Override
    public void createExpertIn(int id, int doctorsId, int specializationId) {
        try (Connection dbConnect = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = dbConnect.prepareStatement(insertStatementS);
            stmt.setInt(1, id);
            stmt.setInt(2, doctorsId);
            stmt.setInt(3, specializationId);
            int i = stmt.executeUpdate();
            LOGGER.info(i + " records inserted");
        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void updateExpertIn(int specializationId, int id) {
        try (Connection dbConnect = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = dbConnect.prepareStatement(updateStatementS);
            stmt.setInt(1, specializationId);
            stmt.setInt(2, id);
            int i = stmt.executeUpdate();
            LOGGER.info(i + " records updated");
        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void deleteExpertInById(int id) {
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
    public List<ExpertInModel> getExpertInBySpecializationId(int id) {
        try (Connection con = DataBaseConnection.getConnection()) {
            DoctorsModel doctors = new DoctorsModel();
            SpecializationModel specializationModel = new SpecializationModel();
            PreparedStatement stmt = con.prepareStatement(getStatement);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            ArrayList<ExpertInModel> expertInModels = new ArrayList<ExpertInModel>();
            while (rs.next()) {
                id = rs.getInt(1);
                int doctorsId = rs.getInt(2);
                int specializationId = rs.getInt(3);
                ExpertInModel expertInModel = new ExpertInModel(id, doctors, specializationModel);
                expertInModels.add(expertInModel);
                expertInModel.toString();
            }
            LOGGER.info("ALL is OK!");
            return expertInModels;
        } catch (Exception e) {
            LOGGER.info(e);
        }
        return null;
    }


}
