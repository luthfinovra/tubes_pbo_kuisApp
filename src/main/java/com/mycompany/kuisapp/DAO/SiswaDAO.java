/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kuisapp.DAO;
import com.mycompany.kuisapp.model.Siswa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author LUTHFI NOVRA
 */
public class SiswaDAO {
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1/kuisApp";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    public void addSiswa(Siswa siswa) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD); 
                PreparedStatement statement = connection.prepareStatement("INSERT INTO siswa (nama, username, password) VALUES (?, ?, ?)",
                        Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, siswa.getNama());
            statement.setString(2, siswa.getUsername());
            statement.setString(3, siswa.getPassword());

            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                // Retrieve the generated keys

                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int generatedId = generatedKeys.getInt(1);
                        // Set the generated ID to the Guru object
                        siswa.setId(generatedId);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
    }

    public boolean isUsernameExists(String username) {
        boolean exists = false;
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD); PreparedStatement statement = connection.prepareStatement("SELECT username FROM siswa WHERE username = ?")) {
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                exists = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
        return exists;
    }

    public Siswa getSiswaByUsername(String username) {
        Siswa siswa = null;
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD); PreparedStatement statement = connection.prepareStatement("SELECT * FROM siswa WHERE username = ?")) {
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String nama = rs.getString("nama");
                String password = rs.getString("password");
                siswa = new Siswa(nama, username, password);
                siswa.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
        return siswa;
    }

}
