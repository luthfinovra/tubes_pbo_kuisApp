/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kuisapp.DAO;

import com.mycompany.kuisapp.model.Quiz;
import com.mycompany.kuisapp.model.QuizGuru;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LUTHFI NOVRA
 */
public class QuizDAO {

    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1/kuisApp";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    public int addQuiz(Quiz quiz) throws SQLException {
        // Implement the logic to add a quiz and its questions to the database
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            // Create a SQL INSERT statement for the quiz table
            String sql = "INSERT INTO quiz (nama, deskripsi, guru_id) VALUES (?, ?, ?)";

            // Use a PreparedStatement to execute the statement and get the generated id
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, quiz.getJudul());
            ps.setString(2, quiz.getDeskripsi());
            ps.setInt(3, quiz.getTeacher_id());
            ps.executeUpdate();
            
            // Get the generated id from the ResultSet
            ResultSet rs = ps.getGeneratedKeys();
            int quizId = -1;
            if (rs.next()) {
                quizId = rs.getInt(1);
            }
            return quizId;
        }
    }

    public List<QuizGuru> getAllQuizzes() {
        List<QuizGuru> quizzesGuru = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD); PreparedStatement statement = connection.prepareStatement(
                "SELECT quiz.*, guru.nama AS nama_guru FROM quiz JOIN guru ON quiz.guru_id = guru.id")) {

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("nama");
                String description = rs.getString("deskripsi");
                int teacherId = rs.getInt("guru_id");
                String teacherName = rs.getString("nama_guru");

                Quiz quiz = new Quiz(title, description, teacherId);
                quiz.setId(id);

                QuizGuru quizGuru = new QuizGuru(quiz, teacherName);
                quizzesGuru.add(quizGuru);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }

        return quizzesGuru;
    }

    public List<Quiz> getQuizzesByTeacherId(int teacherId) {
        List<Quiz> quizzes = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD); PreparedStatement statement = connection.prepareStatement("SELECT * FROM quiz WHERE guru_id = ?")) {
            statement.setInt(1, teacherId);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("nama");
                String description = rs.getString("deskripsi");
                // Add other fields as needed

                Quiz quiz = new Quiz(title, description, teacherId);
                quiz.setId(id);
                quizzes.add(quiz);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }

        return quizzes;
    }

    public boolean deleteQuizById(int quizId) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM quiz WHERE id = ?")) {

            statement.setInt(1, quizId);

            int rowsAffected = statement.executeUpdate();

            return rowsAffected > 0;  // Returns true if at least one row is affected (i.e., the question is deleted)

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
            return false;
        }
    }
    // Add other methods as needed
}
