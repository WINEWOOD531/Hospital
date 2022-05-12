package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.IBillDao;
import com.solvd.hospital.models.BillModel;
import com.solvd.hospital.models.PatientModel;
import com.solvd.hospital.utility.parsers.DataBaseConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class BillDao implements IBillDao {

    private static final Logger LOGGER = LogManager.getLogger(BillDao.class);

    final String deleteStatementS = "DELETE FROM bill WHERE id=?";
    final String getStatement = "SELECT * FROM bill WHERE Patient_id = ?";
    final String insertStatementS = "INSERT INTO bill VALUES (?, ?,?,?)";
    final String updateStatementS = "UPDATE bill SET summ=? WHERE id=?";

    @Override
    public void createBill(int id, Double sum, String paymentDate, int patientId) {
        try (Connection dbConnect = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = dbConnect.prepareStatement(insertStatementS);
            stmt.setInt(1, id);
            stmt.setDouble(2, sum);
            stmt.setString(3, paymentDate);
            stmt.setInt(4, patientId);
            int i = stmt.executeUpdate();
            LOGGER.info(i + " records inserted");
        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void updateBill(Double sum, int id) {
        try (Connection dbConnect = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = dbConnect.prepareStatement(updateStatementS);
            stmt.setDouble(1, sum);
            stmt.setInt(2, id);
            int i = stmt.executeUpdate();
            LOGGER.info(i + " records updated");
        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void deleteBillByPatientId(int id) {
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
    public List<BillModel> getBillByPatientId(int id) {
        try (Connection dbConnect = DataBaseConnection.getConnection()) {
            PatientModel patient = new PatientModel();
            PreparedStatement stmt = dbConnect.prepareStatement(getStatement);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            ArrayList<BillModel> billModels = new ArrayList<BillModel>();
            while (rs.next()) {
                id = rs.getInt(1);
                Double sum = rs.getDouble(2);
                String paymentDate = rs.getString(3);
                int patientId = rs.getInt(4);
                BillModel billModel = new BillModel(id, sum, paymentDate, patient);
                billModels.add(billModel);
                billModel.toString();
            }
            LOGGER.info("ALL is OK!");
            return billModels;
        } catch (Exception e) {
            LOGGER.info(e);
        }
        return null;
    }
}
