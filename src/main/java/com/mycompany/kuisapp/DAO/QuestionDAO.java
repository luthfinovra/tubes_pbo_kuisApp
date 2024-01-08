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

    public int addQuestion(Question question, int teacherId) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD); PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO question (question_text, option1, option2, option3, option4, correct_answer, guru_id) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, question.getQuestion_text());
            statement.setString(2, question.getOption1());
            statement.setString(3, question.getOption2());
            statement.setString(4, question.getOption3());
            statement.setString(5, question.getOption4());
            statement.setInt(6, question.getCorrect_answer());
            statement.setInt(7, teacherId);

            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                // Retrieve the generated keys
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        // Return the generated ID
                        return generatedKeys.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }

        // Return -1 to indicate failure
        return -1;
    }

    public List<Question> getQuestionByTeacherId(int teacherId) {
        List<Question> questions = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD); PreparedStatement statement = connection.prepareStatement("SELECT * FROM question WHERE guru_id = ?")) {
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

    public Question getQuestionById(int questionId) {

        Question question = null;
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD); 
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM question WHERE id = ?")) {
            statement.setInt(1, questionId);

            ResultSet rs = statement.executeQuery();
            rs.next();
            int id = rs.getInt("id");
            String question_text = rs.getString("question_text");
            String option1 = rs.getString("option1");
            String option2 = rs.getString("option2");
            String option3 = rs.getString("option3");
            String option4 = rs.getString("option4");
            int correct_answer = rs.getInt("correct_answer");
            int teacher_id = rs.getInt("guru_id");
            // Add other fields as needed

            question = new Question(question_text, option1, option2, option3, option4, correct_answer, teacher_id);
            question.setId(id);
            
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }

        return question;
    }

    public boolean deleteQuestionById(int questionId) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD); PreparedStatement statement = connection.prepareStatement("DELETE FROM question WHERE id = ?")) {

            statement.setInt(1, questionId);

            int rowsAffected = statement.executeUpdate();

            return rowsAffected > 0;  // Returns true if at least one row is affected (i.e., the question is deleted)

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
            return false;
        }
    }
    
    public boolean updateQuestionById(int questionId, Question question){
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD); 
        PreparedStatement statement = connection.prepareStatement(
                "UPDATE question SET question_text = ?, option1 = ?, option2 = ?, option3 = ?, option4 = ?, correct_answer = ? WHERE id = ?")){
            
            statement.setString(1, question.getQuestion_text());
            statement.setString(2, question.getOption1());
            statement.setString(3, question.getOption2());
            statement.setString(4, question.getOption3());
            statement.setString(5, question.getOption4());
            statement.setInt(6, question.getCorrect_answer());
            
            statement.setInt(7, questionId);
            
            int rowAffected = statement.executeUpdate();
            
            return rowAffected > 0;
        }catch (SQLException e){
            e.printStackTrace();
            
            return false;
        }
    }
    
    
}
