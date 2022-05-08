package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.IMedicinesDao;
import com.solvd.hospital.models.MedicinesModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ResourceBundle;

public class MedicinesDao implements IMedicinesDao {

    private static final Logger LOGGER = LogManager.getLogger(MedicinesDao.class);
    static final String DATABASE_URL = "jdbc:mysql://localhost/hospital";
    static final String USER = "root";
    static final String PASSWORD = "Winewood*531*";
    ResourceBundle resource = ResourceBundle.getBundle("db");
    String url = resource.getString("db.url");
    String user = resource.getString("db.username");
    String pass = resource.getString("db.password");

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //getAllMedicines();
    }

    @Override
    public void createMedicines(MedicinesModel medicines) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO\n" +
                    " Medicines VALUES (?, ?);");
            stmt.setInt(1, medicines.getId());
            stmt.setString(2, medicines.getMedicineName());
            int i = stmt.executeUpdate();
            LOGGER.info(i + " records inserted");
        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void updateMedicines(String medicineName,int id) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("UPDATE Medicines" +
                    " SET medicineName=? WHERE id=?");
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
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("DELETE FROM Medicines WHERE id=?");
            stmt.setInt(1, 9);

            int i = stmt.executeUpdate();
            LOGGER.info(i + " records deleted");

        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public MedicinesModel getMedicinesByName(String medicineName) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("SELECT * " +
                    "FROM Medicines WHERE medicineName LIKE ? ESCAPE '!'");
            stmt.setString(1, "Some medicines"+"%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                LOGGER.info("Id: " + rs.getInt(1) + "\n"
                        + "Medicine Name: " + rs.getString(2));
            }
        } catch (Exception e) {
            LOGGER.info(e);
        }
        return null;
    }

    public static void getAllMedicines() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;

        LOGGER.info("Registering JDBC driver...");

        Class.forName("com.mysql.cj.jdbc.Driver");

        LOGGER.info("Creating database connection...");
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

        LOGGER.info("Executing statement...");
        statement = connection.createStatement();

        String sql;
        sql = "SELECT * FROM Medicines";

        ResultSet resultSet = statement.executeQuery(sql);

        LOGGER.info("Retrieving data from database...");
        LOGGER.info("\nMedicines:");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String medicineName = resultSet.getString("medicineName");

            LOGGER.info("\n================\n");
            LOGGER.info("id: " + id);
            LOGGER.info("Medicine Name:" + medicineName);

        }

        LOGGER.info("Closing connection and releasing resources...");
        resultSet.close();
        statement.close();
        connection.close();
    }
}
