package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.IExpertInDao;
import com.solvd.hospital.models.DoctorsModel;
import com.solvd.hospital.models.ExpertInModel;
import com.solvd.hospital.models.SpecializationModel;
import com.solvd.hospital.utility.connection.DataBaseConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpertInDao implements IExpertInDao {

    private static final Logger LOGGER = LogManager.getLogger(ExpertInDao.class);

    final String deleteStatementS = "DELETE FROM ExpertIn WHERE id=?";
    final String getStatement = "SELECT * FROM ExpertIn WHERE Specialization_id = ?";
    final String insertStatementS = "INSERT INTO ExpertIn VALUES (?, ?,?)";
    final String updateStatementS = "UPDATE ExpertIn SET Specialization_id=? WHERE id=?";
    private static final String GET_ALL = "SELECT * FROM ExpertIn";

    PreparedStatement statement = null;
    ResultSet result = null;

    @Override
    public void createExpertIn(ExpertInModel expertInModel) {
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(insertStatementS);
            statement.setInt(1, expertInModel.getId());
            statement.setInt(2, expertInModel.getDoctors().getId());
            statement.setInt(3, expertInModel.getSpecialization().getId());
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
    public void updateExpertIn(ExpertInModel expertInModel) {
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(updateStatementS);
            statement.setInt(1, expertInModel.getSpecialization().getId());
            statement.setInt(2, expertInModel.getId());
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
    public void deleteExpertInById(ExpertInModel expertInModel) {
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(deleteStatementS);
            statement.setInt(1, expertInModel.getId());
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
    public List<ExpertInModel> getAllExpertInBySpecializationId(int id) {
        Connection con = DataBaseConnection.getConnection();
        ArrayList<ExpertInModel> expertInModels = new ArrayList<ExpertInModel>();
        try {
            statement = con.prepareStatement(getStatement);
            statement.setInt(1, id);
            result = statement.executeQuery();
            while (result.next()) {
                ExpertInModel expertInModel = new ExpertInModel();
                expertInModel.setId(result.getInt(1));
                expertInModel.setDoctorsId(result.getInt(2));
                expertInModel.setSpecializationId(result.getInt(3));
                expertInModels.add(expertInModel);
                expertInModel.toString();
            }
            LOGGER.info("ALL is OK!");
            return expertInModels;
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


    public List<ExpertInModel> getAllExpertIn() {
        Connection con = DataBaseConnection.getConnection();
        ArrayList<ExpertInModel> expertInModels = new ArrayList<ExpertInModel>();
        DoctorsModel doctors = new DoctorsModel();
        SpecializationModel specializationModel = new SpecializationModel();
        try {
            statement = con.prepareStatement(GET_ALL);
            result = statement.executeQuery();
            while (result.next()) {
                ExpertInModel expertInModel = new ExpertInModel();
                expertInModel.setId(result.getInt(1));
                expertInModel.setDoctorsId(result.getInt(2));
                expertInModel.setSpecializationId(result.getInt(3));
                expertInModels.add(expertInModel);
                expertInModel.toString();
            }
            LOGGER.info("ALL is OK!");
            return expertInModels;
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
