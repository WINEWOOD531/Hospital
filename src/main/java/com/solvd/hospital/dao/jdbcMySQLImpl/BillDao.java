package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.IBillDao;
import com.solvd.hospital.models.BillModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ResourceBundle;

public class BillDao implements IBillDao {

    private static final Logger LOGGER = LogManager.getLogger(BillDao.class);
    static final String DATABASE_URL = "jdbc:mysql://localhost/hospital";

    static final String USER = "root";
    static final String PASSWORD = "Winewood*531*";
    ResourceBundle resource = ResourceBundle.getBundle("db");
    String url = resource.getString("db.url");
    String user = resource.getString("db.username");
    String pass = resource.getString("db.password");

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

    }

    @Override
    public void createBill(int id, Double sum, String paymentDate, int patientId) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("INSERT INTO\n" +
                    " bill VALUES (?, ?, ?,?);");
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
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("UPDATE bill SET summ=? WHERE id=?");
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
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("DELETE FROM bill WHERE id=?");
            stmt.setInt(1, id);

            int i = stmt.executeUpdate();
            LOGGER.info(i + " records deleted");

        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public BillModel getBillByPatientId(int id) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM bill WHERE Patient_id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                LOGGER.info("\nId: " + rs.getInt(1) + "\nSum: " + rs.getDouble(2) +
                        "\nPayment date:  " + rs.getString(3) +
                        "\nPatient_id:  " + rs.getInt(4));
            }
        } catch (Exception e) {
            LOGGER.info(e);
        }
        return null;
    }
}
