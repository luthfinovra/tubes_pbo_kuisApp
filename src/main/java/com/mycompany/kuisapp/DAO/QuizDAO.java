/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kuisapp.DAO;

import com.mycompany.kuisapp.model.Quiz;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public void addQuiz(Quiz quiz) {
        // Implement the logic to add a quiz to the database
    }

    public List<Quiz> getQuizzesByTeacherId(int teacherId) {
        List<Quiz> quizzes = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD); 
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM quiz WHERE guru_id = ?")) {
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

    // Add other methods as needed
}
