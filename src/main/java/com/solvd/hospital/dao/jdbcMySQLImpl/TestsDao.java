package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.ITestsDao;
import com.solvd.hospital.models.TestsModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ResourceBundle;

public class TestsDao implements ITestsDao {

    private static final Logger LOGGER = LogManager.getLogger(TestsDao.class);
    static final String DATABASE_URL = "jdbc:mysql://localhost/hospital";
    static final String USER = "root";
    static final String PASSWORD = "Winewood*531*";
    ResourceBundle resource = ResourceBundle.getBundle("db");
    String url = resource.getString("db.url");
    String user = resource.getString("db.username");
    String pass = resource.getString("db.password");

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //getAllTests();
    }

    @Override
    public void createTests(TestsModel tests) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO\n" +
                    " Tests VALUES (?, ?);");
            stmt.setInt(1, tests.getId());
            stmt.setString(2, tests.getTestName());
            int i = stmt.executeUpdate();
            LOGGER.info(i + " records inserted");
        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void updateTests(String testName, int id) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("UPDATE Tests" +
                    " SET testName=? WHERE id=?");
            stmt.setString(1, testName);
            stmt.setInt(2, id);

            int i = stmt.executeUpdate();
            LOGGER.info(i + " records updated");

        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void deleteTestsById(int id) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("DELETE FROM Tests WHERE id=?");
            stmt.setInt(1, 10);

            int i = stmt.executeUpdate();
            LOGGER.info(i + " records deleted");

        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public TestsModel getTestsByName(String name) {

        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("SELECT * " +
                    "FROM Tests WHERE testName LIKE ? ESCAPE '!'");
            stmt.setString(1, "Some test"+"%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                LOGGER.info("Id: " + rs.getInt(1) + "\n"
                        + "Test Name: " + rs.getString(2));
            }
        } catch (Exception e) {
            LOGGER.info(e);
        }
        return null;
    }

    public static void getAllTests() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;

        LOGGER.info("Registering JDBC driver...");

        Class.forName("com.mysql.cj.jdbc.Driver");

        LOGGER.info("Creating database connection...");
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

        LOGGER.info("Executing statement...");
        statement = connection.createStatement();

        String sql;
        sql = "SELECT * FROM Tests";

        ResultSet resultSet = statement.executeQuery(sql);

        LOGGER.info("Retrieving data from database...");
        LOGGER.info("\nTests:");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String testName = resultSet.getString("testName");

            LOGGER.info("\n================\n");
            LOGGER.info("id: " + id);
            LOGGER.info("Test Name:" + testName);

        }

        LOGGER.info("Closing connection and releasing resources...");
        resultSet.close();
        statement.close();
        connection.close();
    }
}
