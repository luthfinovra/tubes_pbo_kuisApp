/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kuisapp.DAO;

import com.mycompany.kuisapp.model.Question;
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
public class QuestionDAO {
   private static final String JDBC_URL = "jdbc:mysql://127.0.0.1/kuisApp";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    public void addQuiz(Quiz quiz) {
        // Implement the logic to add a quiz to the database
    }

    public List<Question> getQuestionByTeacherId(int teacherId) {
        List<Question> questions = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD); 
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM question WHERE guru_id = ?")) {
                statement.setInt(1, teacherId);

                ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String question_text = rs.getString("question_text");
                String option1 = rs.getString("option1");
                String option2 = rs.getString("option2");
                String option3 = rs.getString("option3");
                String option4 = rs.getString("option4");
                int correct_answer = rs.getInt("correct_answer");
                // Add other fields as needed

                Question question = new Question(question_text, option1, option2, option3, option4, correct_answer, teacherId);
                question.setId(id);
                questions.add(question);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }

        return questions;
    }
  
}
