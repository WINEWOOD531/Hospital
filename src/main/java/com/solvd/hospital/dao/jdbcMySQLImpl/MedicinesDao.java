package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.IMedicinesDao;

import com.solvd.hospital.models.MedicinesModel;
import com.solvd.hospital.utility.connection.DataBaseConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicinesDao implements IMedicinesDao {

    private static final Logger LOGGER = LogManager.getLogger(MedicinesDao.class);
    final String deleteStatementS = "DELETE FROM Medicines WHERE id=?";
    final String getStatement = "SELECT * FROM Medicines WHERE id=?";
    final String insertStatementS = "INSERT INTO Medicines VALUES (?, ?)";
    final String updateStatementS = "UPDATE Medicines SET medicineName=? WHERE id=?";
    private static final String GET_ALL = "SELECT * FROM Medicines ORDER BY id";

    PreparedStatement statement = null;
    ResultSet result = null;

    @Override
    public void createMedicines(MedicinesModel medicinesModel) {
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(insertStatementS);
            statement.setInt(1, medicinesModel.getId());
            statement.setString(2, medicinesModel.getMedicineName());
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
    public void updateMedicines(MedicinesModel medicinesModel) {
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(updateStatementS);
            statement.setString(1, medicinesModel.getMedicineName());
            statement.setInt(2, medicinesModel.getId());
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
    public void deleteMedicinesById(MedicinesModel medicinesModel) {
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(deleteStatementS);
            statement.setInt(1, medicinesModel.getId());
            int i = statement.executeUpdate();
            LOGGER.info(i + " records deleted");
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
    public MedicinesModel getMedicinesById(int id) {
        Connection con = DataBaseConnection.getConnection();
        MedicinesModel medicinesModel = new MedicinesModel();
        try {
            statement = con.prepareStatement(getStatement);
            statement.setInt(1, id);
            result = statement.executeQuery();
            while (result.next()) {
                medicinesModel.setId(result.getInt("id"));
                medicinesModel.setMedicineName(result.getString("medicineName"));
                medicinesModel.toString();
            }
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
        return medicinesModel;
    }

    public List<MedicinesModel> getAllMedicines() {
        Connection con = DataBaseConnection.getConnection();
        ArrayList<MedicinesModel> medicinesModels = new ArrayList<MedicinesModel>();
        try {
            statement = con.prepareStatement(GET_ALL);
            result = statement.executeQuery();
            while (result.next()) {
                MedicinesModel medicinesModel = new MedicinesModel();
                medicinesModel.setId(result.getInt("id"));
                medicinesModel.setMedicineName(result.getString("medicineName"));
                medicinesModels.add(medicinesModel);
                medicinesModel.toString();
            }
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
        return medicinesModels;
    }

}
