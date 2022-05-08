package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.IExpertInDao;
import com.solvd.hospital.models.ExpertInModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ResourceBundle;

public class ExpertInDao implements IExpertInDao {

    private static final Logger LOGGER = LogManager.getLogger(ExpertInDao.class);

    static final String DATABASE_URL = "jdbc:mysql://localhost/hospital";

    static final String USER = "root";
    static final String PASSWORD = "Winewood*531*";
    ResourceBundle resource = ResourceBundle.getBundle("db");
    String url = resource.getString("db.url");
    String user = resource.getString("db.username");
    String pass = resource.getString("db.password");

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //getAllExpertIn();
    }

    @Override
    public void createExpertIn(int id, int doctorsId, int specializationId) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("INSERT INTO\n" +
                    " ExpertIn VALUES (?, ?, ?);");
            stmt.setInt(1, id);
            stmt.setInt(2, doctorsId);
            stmt.setInt(3, specializationId);

            int i = stmt.executeUpdate();
            LOGGER.info(i + " records inserted");

        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void updateExpertIn(int specializationId, int id) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("UPDATE ExpertIn SET Specialization_id=? WHERE id=?");
            stmt.setInt(1, specializationId);
            stmt.setInt(2, id);

            int i = stmt.executeUpdate();
            LOGGER.info(i + " records updated");

        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void deleteExpertInById(int id) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("DELETE FROM ExpertIn WHERE id=?");
            stmt.setInt(1, 9);

            int i = stmt.executeUpdate();
            LOGGER.info(i + " records deleted");

        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public ExpertInModel getExpertInBySpecializationId(int id) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM ExpertIn WHERE Specialization_id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                LOGGER.info("\nId: " + rs.getInt(1) + "\nDoctors Id: " + rs.getInt(2) +
                        "\nSpecialization_id  " + rs.getInt(3));
            }
        } catch (Exception e) {
            LOGGER.info(e);
        }
        return null;
    }

    public static void getAllExpertIn() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;

        LOGGER.info("Registering JDBC driver...");

        Class.forName("com.mysql.cj.jdbc.Driver");

        LOGGER.info("Creating database connection...");
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

        LOGGER.info("Executing statement...");
        statement = connection.createStatement();

        String sql;
        sql = "SELECT * FROM ExpertIn";

        ResultSet resultSet = statement.executeQuery(sql);

        LOGGER.info("Retrieving data from database...");
        LOGGER.info("\nExpertIn:");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int doctorsId = resultSet.getInt("Doctors_id");
            int specializationId = resultSet.getInt("Specialization_id");

            LOGGER.info("\n================\n");
            LOGGER.info("id: " + id);
            LOGGER.info("Doctors Id:" + doctorsId);
            LOGGER.info("Specialization Id: " + specializationId);
        }

        LOGGER.info("Closing connection and releasing resources...");
        resultSet.close();
        statement.close();
        connection.close();
    }
}
