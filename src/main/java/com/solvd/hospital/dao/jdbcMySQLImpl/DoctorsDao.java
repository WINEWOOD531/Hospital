package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.IDoctorsDao;
import com.solvd.hospital.models.DoctorsModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ResourceBundle;

public class DoctorsDao implements IDoctorsDao {

    private static final Logger LOGGER = LogManager.getLogger(DoctorsDao.class);

    static final String DATABASE_URL = "jdbc:mysql://localhost/hospital";

    static final String USER = "root";
    static final String PASSWORD = "Winewood*531*";
    ResourceBundle resource = ResourceBundle.getBundle("db");
    String url = resource.getString("db.url");
    String user = resource.getString("db.username");
    String pass = resource.getString("db.password");

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //getAllDoctors();
    }

    @Override
    public void createDoctor(int id, String availaibleDate, int personId) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("INSERT INTO\n" +
                    " Doctors VALUES (?, ?, ?);");
            stmt.setInt(1, id);
            stmt.setString(2, availaibleDate);
            stmt.setInt(3, personId);

            int i = stmt.executeUpdate();
            LOGGER.info(i + " records inserted");

        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void updateDoctorById(int id) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("UPDATE Doctors SET availaibleDate=? WHERE id=?");
            stmt.setString(1, "2022-05-19");
            stmt.setInt(2, 9);

            int i = stmt.executeUpdate();
            LOGGER.info(i + " records updated");

        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void deleteDoctorById(int id) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("DELETE FROM Doctors WHERE id=?");
            stmt.setInt(1, 9);

            int i = stmt.executeUpdate();
            LOGGER.info(i + " records deleted");

        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public DoctorsModel getDoctorByDate(String date) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("SELECT * " +
                    "FROM Doctors WHERE availaibleDate LIKE ? ESCAPE '!'");
            stmt.setString(1, date + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                LOGGER.info("Id: " + rs.getInt(1) + "\n"
                        + "Availaible Date: " + rs.getString(2) +
                        "\n Person Id:  " + rs.getInt(3));
            }
        } catch (Exception e) {
            LOGGER.info(e);
        }
        return null;
    }

    public static void getAllDoctors() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;

        LOGGER.info("Registering JDBC driver...");

        Class.forName("com.mysql.cj.jdbc.Driver");

        LOGGER.info("Creating database connection...");
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

        LOGGER.info("Executing statement...");
        statement = connection.createStatement();

        String sql;
        sql = "SELECT * FROM Doctors";

        ResultSet resultSet = statement.executeQuery(sql);

        LOGGER.info("Retrieving data from database...");
        LOGGER.info("\nDoctors:");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String availaibleDate = resultSet.getString("availaibleDate");
            int personId = resultSet.getInt("Person_id");

            LOGGER.info("\n================\n");
            LOGGER.info("id: " + id);
            LOGGER.info("Availaible Date:" + availaibleDate);
            LOGGER.info("Person Id: " + personId);
        }

        LOGGER.info("Closing connection and releasing resources...");
        resultSet.close();
        statement.close();
        connection.close();
    }
}
