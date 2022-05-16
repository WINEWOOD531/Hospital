package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.ISpecializationDao;

import com.solvd.hospital.models.SpecializationModel;
import com.solvd.hospital.utility.connection.DataBaseConnection;
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
    private static final String GET_ALL = "SELECT * FROM Specialization";
    PreparedStatement statement = null;
    ResultSet result = null;

    @Override
    public void createSpecialization(SpecializationModel specializationModel) {
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(insertStatementS);
            statement.setInt(1, specializationModel.getId());
            statement.setString(2, specializationModel.getSpecialization());
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
    public void updateSpecialization(SpecializationModel specializationModel) {
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(updateStatementS);
            statement.setString(1, specializationModel.getSpecialization());
            statement.setInt(2, specializationModel.getId());
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
    public void deleteSpecializationById(SpecializationModel specializationModel) {
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(deleteStatementS);
            statement.setInt(1, specializationModel.getId());
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
    public List<SpecializationModel> getSpecializationByName(String name) {
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(getStatement);
            statement.setString(1, name);
            result = statement.executeQuery();
            ArrayList<SpecializationModel> specializationModels = new ArrayList<SpecializationModel>();
            while (result.next()) {
                SpecializationModel specializationModel = new SpecializationModel();
                specializationModel.setId(result.getInt(1));
                specializationModel.setSpecialization(result.getString(2));
                specializationModels.add(specializationModel);
                specializationModel.toString();
            }
            LOGGER.info("ALL is OK!");
            return specializationModels;
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

    public List<SpecializationModel> getAllSpecialization() {
        Connection con = DataBaseConnection.getConnection();
        ArrayList<SpecializationModel> specializationModels = new ArrayList<SpecializationModel>();
        try {
            statement = con.prepareStatement(GET_ALL);
            result = statement.executeQuery();
            while (result.next()) {
                SpecializationModel specializationModel = new SpecializationModel();
                specializationModel.setId(result.getInt(1));
                specializationModel.setSpecialization(result.getString(2));
                specializationModels.add(specializationModel);
                specializationModel.toString();
            }
            LOGGER.info("ALL is OK!");
            return specializationModels;
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
        return null;
    }

}
