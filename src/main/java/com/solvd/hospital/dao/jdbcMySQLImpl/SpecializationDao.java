package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.ISpecializationDao;
import com.solvd.hospital.models.SpecializationModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ResourceBundle;

public class SpecializationDao implements ISpecializationDao {

    private static final Logger LOGGER = LogManager.getLogger(SpecializationDao.class);
    static final String DATABASE_URL = "jdbc:mysql://localhost/hospital";
    static final String USER = "root";
    static final String PASSWORD = "Winewood*531*";
    ResourceBundle resource = ResourceBundle.getBundle("db");
    String url = resource.getString("db.url");
    String user = resource.getString("db.username");
    String pass = resource.getString("db.password");

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //getAllSpecialization();

    }

    @Override
    public void createSpecialization(SpecializationModel specialization) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO\n" +
                    " Specialization VALUES (?, ?);");
            stmt.setInt(1, specialization.getId());
            stmt.setString(2, specialization.getSpecialization());
            int i = stmt.executeUpdate();
            LOGGER.info(i + " records inserted");
        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void updateSpecialization(String specializationName, int id) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("UPDATE Specialization" +
                    " SET specializationName=? WHERE id=?");
            stmt.setString(1, specializationName);
            stmt.setInt(2, id);

            int i = stmt.executeUpdate();
            LOGGER.info(i + " records updated");

        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void deleteSpecializationById(int id) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("DELETE FROM Specialization WHERE id=?");
            stmt.setInt(1, 6);

            int i = stmt.executeUpdate();
            LOGGER.info(i + " records deleted");

        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public SpecializationModel getSpecializationByName(String name) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("SELECT * " +
                    "FROM Specialization WHERE specializationName = ?");
            stmt.setString(1, "Surgery");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                LOGGER.info("Id: " + rs.getInt(1) + "\n"
                        + "Specialization Name: " + rs.getString(2));
            }
        } catch (Exception e) {
            LOGGER.info(e);
        }
        return null;
    }

    public static void getAllSpecialization() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;

        LOGGER.info("Registering JDBC driver...");

        Class.forName("com.mysql.cj.jdbc.Driver");

        LOGGER.info("Creating database connection...");
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

        LOGGER.info("Executing statement...");
        statement = connection.createStatement();

        String sql;
        sql = "SELECT * FROM Specialization";

        ResultSet resultSet = statement.executeQuery(sql);

        LOGGER.info("Retrieving data from database...");
        LOGGER.info("\nSpecializations:");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String specializationName = resultSet.getString("specializationName");

            LOGGER.info("\n================\n");
            LOGGER.info("id: " + id);
            LOGGER.info("Specialization Name:" + specializationName);

        }

        LOGGER.info("Closing connection and releasing resources...");
        resultSet.close();
        statement.close();
        connection.close();
    }
}
