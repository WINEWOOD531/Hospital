package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.INursesDao;
import com.solvd.hospital.models.NursesModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ResourceBundle;

public class NursesDao implements INursesDao {

    private static final Logger LOGGER = LogManager.getLogger(NursesDao.class);

    static final String DATABASE_URL = "jdbc:mysql://localhost/hospital";

    static final String USER = "root";
    static final String PASSWORD = "Winewood*531*";
    ResourceBundle resource = ResourceBundle.getBundle("db");
    String url = resource.getString("db.url");
    String user = resource.getString("db.username");
    String pass = resource.getString("db.password");

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //getAllNurses();

    }

    @Override
    public void createNurse(int id, int personId, int workExperience) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("INSERT INTO\n" +
                    " Nurses VALUES (?, ?, ?);");
            stmt.setInt(1, id);
            stmt.setInt(2, personId);
            stmt.setInt(3, workExperience);

            int i = stmt.executeUpdate();
            LOGGER.info(i + " records inserted");

        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void updateNurse(int workExperience, int id) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("UPDATE Nurses SET workExperience=? WHERE id=?");
            stmt.setInt(1, workExperience);
            stmt.setInt(2, id);

            int i = stmt.executeUpdate();
            LOGGER.info(i + " records updated");

        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void deleteNurseById(int id) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("DELETE FROM Nurses WHERE id=?");
            stmt.setInt(1, id);

            int i = stmt.executeUpdate();
            LOGGER.info(i + " records deleted");

        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public NursesModel getNurseByIdWorkExperience(int workExperience) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM Nurses WHERE workExperience > ?");
            stmt.setInt(1, workExperience);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                LOGGER.info("Id: " + rs.getInt(1) + "\nPerson Id: " + rs.getInt(2) +
                        "\nWork Experience: " + rs.getInt(3));
            }
        } catch (Exception e) {
            LOGGER.info(e);
        }
        return null;
    }

    public static void getAllNurses() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;

        LOGGER.info("Registering JDBC driver...");

        Class.forName("com.mysql.cj.jdbc.Driver");

        LOGGER.info("Creating database connection...");
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

        LOGGER.info("Executing statement...");
        statement = connection.createStatement();

        String sql;
        sql = "SELECT * FROM Nurses";

        ResultSet resultSet = statement.executeQuery(sql);

        LOGGER.info("Retrieving data from database...");
        LOGGER.info("\nNurses:");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int personId = resultSet.getInt("Person_id");
            int workExperience = resultSet.getInt("workExperience");

            LOGGER.info("\n================\n");
            LOGGER.info("id: " + id);
            LOGGER.info("Person id:" + personId);
            LOGGER.info("Work Experience: " + workExperience);
        }

        LOGGER.info("Closing connection and releasing resources...");
        resultSet.close();
        statement.close();
        connection.close();
    }
}
