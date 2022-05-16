package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.ITakesDao;
import com.solvd.hospital.models.TakesModel;
import com.solvd.hospital.utility.connection.DataBaseConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;


public class TakesDao implements ITakesDao {

    private static final Logger LOGGER = LogManager.getLogger(TakesDao.class);
    final String deleteStatementS = "DELETE FROM takes WHERE id=?";
    final String getStatement = "SELECT * FROM takes WHERE Medicines_id = ?";
    final String insertStatementS = "INSERT INTO takes VALUES (?, ?, ?,?,?)";
    final String updateStatementS = "UPDATE takes SET quantiti=? WHERE id=?";
    private static final String GET_ALL = "SELECT * FROM takes";
    PreparedStatement statement = null;
    ResultSet result = null;

    @Override
    public void createTakes(TakesModel takesModel) {
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(insertStatementS);
            statement.setInt(1, takesModel.getId());
            statement.setDouble(2, takesModel.getQuantity());
            statement.setString(3, takesModel.getTakesDate());
            statement.setInt(4, takesModel.getMedicines().getId());
            statement.setInt(5, takesModel.getPatient().getId());
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
    public void updateTakes(TakesModel takesModel) {
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(updateStatementS);
            statement.setDouble(1, takesModel.getQuantity());
            statement.setInt(2, takesModel.getId());
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
    public void deleteTakesById(TakesModel takesModel) {
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(deleteStatementS);
            statement.setInt(1, takesModel.getId());
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
    public ArrayList<TakesModel> getTakesByMedicineId(int id) {
        ArrayList<TakesModel> takesModels = new ArrayList<>();
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(getStatement);
            statement.setInt(1, id);
            result = statement.executeQuery();
            while (result.next()) {
                TakesModel takesModel = new TakesModel();
                takesModel.setId(result.getInt(1));
                takesModel.setQuantity(result.getDouble(2));
                takesModel.setTakesDate(result.getString(3));
                takesModel.setMedicinesId(result.getInt("Medicines_id"));
                takesModel.setPatientId(result.getInt("Patient_id"));
                takesModels.add(takesModel);
                takesModel.toString();
            }
            LOGGER.info("ALL is OK!");
            return takesModels;
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

    public ArrayList<TakesModel> getAllTakes() {
        ArrayList<TakesModel> takesModels = new ArrayList<>();
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(GET_ALL);
            result = statement.executeQuery();
            while (result.next()) {
                TakesModel takesModel = new TakesModel();
                takesModel.setId(result.getInt(1));
                takesModel.setQuantity(result.getDouble(2));
                takesModel.setTakesDate(result.getString(3));
                takesModel.setMedicinesId(result.getInt("Medicines_id"));
                takesModel.setPatientId(result.getInt("Patient_id"));
                takesModels.add(takesModel);
                takesModel.toString();
            }
            LOGGER.info("ALL is OK!");
            return takesModels;
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
