package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.IPatientDao;
import com.solvd.hospital.models.PatientModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ResourceBundle;

public class PatientDao implements IPatientDao {

    private static final Logger LOGGER = LogManager.getLogger(PatientDao.class);
    static final String DATABASE_URL = "jdbc:mysql://localhost/hospital";

    static final String USER = "root";
    static final String PASSWORD = "Winewood*531*";
    ResourceBundle resource = ResourceBundle.getBundle("db");
    String url = resource.getString("db.url");
    String user = resource.getString("db.username");
    String pass = resource.getString("db.password");

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //getAllPatient();
    }

    @Override
    public void createPatient(int id, int age, String bloodGroup, String sex, int personId) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("INSERT INTO\n" +
                    " Patient VALUES (?, ?, ?,?,?);");
            stmt.setInt(1, id);
            stmt.setInt(2, age);
            stmt.setString(3, bloodGroup);
            stmt.setString(4, sex);
            stmt.setInt(5, personId);

            int i = stmt.executeUpdate();
            LOGGER.info(i + " records inserted");

        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void updatePatient(String bloodGroup, int id) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("UPDATE Patient SET bloodGroup=? WHERE id=?");
            stmt.setString(1, bloodGroup);
            stmt.setInt(2, id);

            int i = stmt.executeUpdate();
            LOGGER.info(i + " records updated");

        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void deletePatientById(int id) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("DELETE FROM Patient WHERE id=?");
            stmt.setInt(1, id);

            int i = stmt.executeUpdate();
            LOGGER.info(i + " records deleted");

        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public PatientModel getPatientByAge(int age) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM Patient WHERE age < ?");
            stmt.setInt(1, age);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                LOGGER.info("Id: " + rs.getInt(1) + "\nAge: " + rs.getInt(2) +
                        "\nBlood Group: " + rs.getString(3) +
                        "\nSex: " + rs.getString(4) +
                        "\nPerson Id: " + rs.getInt(5));
            }
        } catch (Exception e) {
            LOGGER.info(e);
        }
        return null;
    }

    public static void getAllPatient() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;

        LOGGER.info("Registering JDBC driver...");

        Class.forName("com.mysql.cj.jdbc.Driver");

        LOGGER.info("Creating database connection...");
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

        LOGGER.info("Executing statement...");
        statement = connection.createStatement();

        String sql;
        sql = "SELECT * FROM Patient";

        ResultSet resultSet = statement.executeQuery(sql);

        LOGGER.info("Retrieving data from database...");
        LOGGER.info("\nPatients:");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int age = resultSet.getInt("age");
            String bloodGroup = resultSet.getString("bloodGroup");
            String sex = resultSet.getString("sex");
            int personId = resultSet.getInt("Person_id");

            LOGGER.info("\n================\n");
            LOGGER.info("id: " + id);
            LOGGER.info("Age: " + age);
            LOGGER.info("Blood Group: " + bloodGroup);
            LOGGER.info("Sex: " + sex);
            LOGGER.info("Person id:" + personId);
        }

        LOGGER.info("Closing connection and releasing resources...");
        resultSet.close();
        statement.close();
        connection.close();
    }
}
