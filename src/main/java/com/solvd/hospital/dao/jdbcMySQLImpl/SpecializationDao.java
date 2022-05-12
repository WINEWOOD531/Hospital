package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.ISpecializationDao;

import com.solvd.hospital.models.SpecializationModel;
import com.solvd.hospital.utility.parsers.DataBaseConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class SpecializationDao implements ISpecializationDao {

    private static final Logger LOGGER = LogManager.getLogger(SpecializationDao.class);

    final String deleteStatementS = "DELETE FROM Specialization WHERE id=?";
    final String getStatement = "SELECT * FROM Specialization WHERE specializationName = ?";
    final String insertStatementS = "INSERT INTO Specialization VALUES (?, ?)";
    final String updateStatementS = "UPDATE Specialization SET specializationName=? WHERE id=?";

    @Override
    public void createSpecialization(int id, String medicineName) {
        try (Connection dbConnect = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = dbConnect.prepareStatement(insertStatementS);
            stmt.setInt(1, id);
            stmt.setString(2, medicineName);
            int i = stmt.executeUpdate();
            LOGGER.info(i + " records inserted");
        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void updateSpecialization(String specializationName, int id) {
        try (Connection dbConnect = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = dbConnect.prepareStatement(updateStatementS);
            stmt.setString(1, specializationName);
            stmt.setInt(2, id);
            int i = stmt.executeUpdate();
            LOGGER.info(i + " records updated");
        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void deleteSpecializationById(int id) {
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
    public List<SpecializationModel> getSpecializationByName(String name) {
        try (Connection dbConnect = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = dbConnect.prepareStatement(getStatement);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            ArrayList<SpecializationModel> specializationModels = new ArrayList<SpecializationModel>();
            while (rs.next()) {
                int id = rs.getInt(1);
                name = rs.getString(2);
                SpecializationModel specializationModel = new SpecializationModel(id, name);
                specializationModels.add(specializationModel);
                specializationModel.toString();
            }
            LOGGER.info("ALL is OK!");
            return specializationModels;
        } catch (Exception e) {
            LOGGER.info(e);
        }
        return null;
    }

}
