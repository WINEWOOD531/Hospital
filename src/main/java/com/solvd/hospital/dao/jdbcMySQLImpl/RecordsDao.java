package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.IRecordsDao;
import com.solvd.hospital.models.RecordsModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ResourceBundle;

public class RecordsDao implements IRecordsDao {

    private static final Logger LOGGER = LogManager.getLogger(RecordsDao.class);

    ResourceBundle resource = ResourceBundle.getBundle("db");
    String url = resource.getString("db.url");
    String user = resource.getString("db.username");
    String pass = resource.getString("db.password");

    @Override
    public void createRecords(int id, String recordAnalysis, int patientId) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("INSERT INTO\n" +
                    " records VALUES (?, ?, ?);");
            stmt.setInt(1, id);
            stmt.setString(2, recordAnalysis);
            stmt.setInt(3, patientId);

            int i = stmt.executeUpdate();
            LOGGER.info(i + " records inserted");

        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void updateRecords(int id, String text) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("UPDATE records SET recordAnalysis=? WHERE id=?");
            stmt.setString(1, text);
            stmt.setInt(2, id);

            int i = stmt.executeUpdate();
            LOGGER.info(i + " records updated");

        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void deleteRecordsById(int id) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("DELETE FROM records WHERE id=?");
            stmt.setInt(1, id);

            int i = stmt.executeUpdate();
            LOGGER.info(i + " records deleted");

        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public RecordsModel getRecordsByPatientId(int id) {

        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM records WHERE Patient_id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                LOGGER.info("\nId: " + rs.getInt(1) + "\nRecord analysis: " + rs.getInt(2) +
                        "\nPatient_id:  " + rs.getInt(3));
            }
        } catch (Exception e) {
            LOGGER.info(e);
        }
        return null;
    }
}
