package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.IMedicinesDao;

import com.solvd.hospital.models.MedicinesModel;
import com.solvd.hospital.utility.parsers.DataBaseConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MedicinesDao implements IMedicinesDao {

    private static final Logger LOGGER = LogManager.getLogger(MedicinesDao.class);
    final String deleteStatementS = "DELETE FROM Medicines WHERE id=?";
    final String getStatement = "SELECT * FROM Medicines WHERE medicineName LIKE ? ESCAPE '!'";
    final String insertStatementS = "INSERT INTO Medicines VALUES (?, ?)";
    final String updateStatementS = "UPDATE Medicines SET medicineName=? WHERE id=?";

    @Override
    public void createMedicines(int id, String medicineName) {
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
    public void updateMedicines(String medicineName, int id) {
        try (Connection dbConnect = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = dbConnect.prepareStatement(updateStatementS);
            stmt.setString(1, medicineName);
            stmt.setInt(2, id);
            int i = stmt.executeUpdate();
            LOGGER.info(i + " records updated");
        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void deleteMedicinesById(int id) {
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
    public List<MedicinesModel> getMedicinesByName(String medicineName) {
        try (Connection dbConnect = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = dbConnect.prepareStatement(getStatement);
            stmt.setString(1, medicineName + "%");
            ResultSet rs = stmt.executeQuery();
            ArrayList<MedicinesModel> medicinesModels = new ArrayList<MedicinesModel>();
            while (rs.next()) {
                int id = rs.getInt(1);
                medicineName = rs.getString(2);
                MedicinesModel medicinesModel = new MedicinesModel(id, medicineName);
                medicinesModels.add(medicinesModel);
                medicinesModel.toString();
            }
            LOGGER.info("ALL is OK!");
            return medicinesModels;
        } catch (Exception e) {
            LOGGER.info(e);
        }
        return null;
    }


}
