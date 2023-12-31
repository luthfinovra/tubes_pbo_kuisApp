/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kuisapp.DAO;

import com.mycompany.kuisapp.model.QuizQuestion;
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
public class QuizQuestionDAO {

    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1/kuisApp";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    public boolean addQuizQuestion(int quizId, int questionId) throws SQLException {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            // Create a SQL INSERT statement for the quiz table
            String sql = "INSERT INTO quiz_question (quiz_id, question_id) VALUES (?, ?)";

            // Use a PreparedStatement to execute the statement and get the generated id
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, quizId);
            ps.setInt(2, questionId);
            ps.executeUpdate();

            return true;
        }
    }
    
    
    public List<QuizQuestion> getQuizQuestion(int quizId) {
        
        List<QuizQuestion> quizQuestions = new ArrayList<>();
        
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD); 
                PreparedStatement statement = 
                        connection.prepareStatement("SELECT * FROM `quiz_question` WHERE quiz_id = ?")) {
            statement.setInt(1, quizId);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int questionId = rs.getInt("question_id");

                QuizQuestion quizQuestion = new QuizQuestion(quizId, questionId);
                quizQuestions.add(quizQuestion);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
        return quizQuestions;
    }
}