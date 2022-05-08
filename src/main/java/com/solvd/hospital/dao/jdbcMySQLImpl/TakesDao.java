package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.ITakesDao;
import com.solvd.hospital.models.TakesModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ResourceBundle;

public class TakesDao implements ITakesDao {

    private static final Logger LOGGER = LogManager.getLogger(TakesDao.class);
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
    public void createTakes(int id, Double quantiti, String takesDate, int medicinessId, int patientsId) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("INSERT INTO\n" +
                    " takes VALUES (?, ?, ?,?,?);");
            stmt.setInt(1, id);
            stmt.setDouble(2, quantiti);
            stmt.setString(3, takesDate);
            stmt.setInt(4, medicinessId);
            stmt.setInt(5, patientsId);


            int i = stmt.executeUpdate();
            LOGGER.info(i + " records inserted");

        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void updateTakes(Double quantiti, int id) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("UPDATE takes SET quantiti=? WHERE id=?");
            stmt.setDouble(1, quantiti);
            stmt.setInt(2, id);

            int i = stmt.executeUpdate();
            LOGGER.info(i + " records updated");

        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void deleteTakesById(int id) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("DELETE FROM takes WHERE id=?");
            stmt.setInt(1, id);

            int i = stmt.executeUpdate();
            LOGGER.info(i + " records deleted");

        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Override
    public TakesModel getTakesByMedicineId(int id) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM takes WHERE Medicines_id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                LOGGER.info("\nId: " + rs.getInt(1) +
                        "\nQuantiti: " + rs.getDouble(2) +
                        "\nTakes date:  " + rs.getString(3) +
                        "\nMedicines_id:  " + rs.getInt(4) +
                        "\nPatient_id:  " + rs.getInt(5));
            }
        } catch (Exception e) {
            LOGGER.info(e);
        }
        return null;
    }
}
