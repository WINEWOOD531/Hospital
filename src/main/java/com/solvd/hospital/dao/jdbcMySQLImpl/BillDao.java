package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.IBillDao;
import com.solvd.hospital.models.BillModel;
import com.solvd.hospital.models.PatientModel;
import com.solvd.hospital.utility.connection.DataBaseConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class BillDao implements IBillDao {

    private static final Logger LOGGER = LogManager.getLogger(BillDao.class);

    final String deleteStatementS = "DELETE FROM bill WHERE id=?";
    final String getStatement = "SELECT * FROM bill WHERE id = ?";
    final String insertStatementS = "INSERT INTO bill VALUES (?, ?,?,?)";
    final String updateStatementS = "UPDATE bill SET summ=? WHERE id=?";

    private static final String GET_ALL = "SELECT * FROM bill";
    PreparedStatement statement = null;
    ResultSet result = null;

    @Override
    public void createBill(BillModel billModel) {
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(insertStatementS);
            statement.setInt(1, billModel.getId());
            statement.setDouble(2, billModel.getSum());
            statement.setString(3, billModel.getPaymentDate());
            statement.setInt(4, billModel.getPatient().getId());
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
    public void updateBill(BillModel billModel) {
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(updateStatementS);
            statement.setDouble(1, billModel.getSum());
            statement.setInt(2, billModel.getId());
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
    public void deleteBillByPatientId(BillModel billModel) {
        Connection dbConnect = DataBaseConnection.getConnection();
        try {
            statement = dbConnect.prepareStatement(deleteStatementS);
            statement.setInt(1, billModel.getId());
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
    public BillModel getBillById(int id) {
        Connection dbConnect = DataBaseConnection.getConnection();
        PatientModel patient = new PatientModel();
        BillModel billModel = new BillModel();
        try {
            statement = dbConnect.prepareStatement(getStatement);
            statement.setInt(1, id);
            result = statement.executeQuery();
            while (result.next()) {
                billModel.setId(result.getInt(1));
                billModel.setSum(result.getDouble(2));
                billModel.setPaymentDate(result.getString(3));
                patient.setId(result.getInt(1));
                billModel.setPatient(patient);
                billModel.toString();
            }
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
        return billModel;
    }

    public List<BillModel> getAllBills() {
        Connection dbConnect = DataBaseConnection.getConnection();
        PatientModel patient = new PatientModel();
        ArrayList<BillModel> billModels = new ArrayList<BillModel>();
        try {
            statement = dbConnect.prepareStatement(GET_ALL);
            result = statement.executeQuery();
            while (result.next()) {
                BillModel billModel = new BillModel();
                billModel.setId(result.getInt(1));
                billModel.setSum(result.getDouble(2));
                billModel.setPaymentDate(result.getString(3));
                PatientDao patientDao= new PatientDao();
                billModel.setPatient(patientDao.getPatientById(result.getInt(4)));
                //billModel.setPatient(new PatientDao().getPatientById(result.getInt(4)));
                // billModel.setPatientId(result.getInt(4));
                billModels.add(billModel);
                billModel.toString();
            }
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
        return billModels;
    }
}
