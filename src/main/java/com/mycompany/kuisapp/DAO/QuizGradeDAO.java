/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kuisapp.DAO;

import com.mycompany.kuisapp.model.Quiz;
import com.mycompany.kuisapp.model.QuizGrade;
import com.mycompany.kuisapp.model.QuizResponses;
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
public class QuizGradeDAO {
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1/kuisApp";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    public int addQuizResponse(QuizGrade grade) throws SQLException {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            
            String sql = "INSERT INTO quiz_grade (siswa_id, quiz_id, grade) VALUES (?, ?, ?)";

            
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, grade.getSiswa_id());
            ps.setInt(2, grade.getQuiz_id());
            ps.setFloat(3, grade.getGrade());
            ps.executeUpdate();

            
            ResultSet rs = ps.getGeneratedKeys();
            int gradeId = -1;
            if (rs.next()) {
                gradeId = rs.getInt(1);
            }
            return gradeId;
        }
    }
    
    public List<QuizGrade> getQuizGradeByStudentId(int siswaId) {
        List<QuizGrade> grades = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD); 
                PreparedStatement statement = 
                        connection.prepareStatement("SELECT * FROM quiz_grade WHERE siswa_id = ?")) {
            statement.setInt(1, siswaId);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int siswa_id = rs.getInt("siswa_id");
                int quiz_id = rs.getInt("quiz_id");
                float grade = rs.getFloat("grade");
                // Add other fields as needed

                QuizGrade quizGrade = new QuizGrade(siswa_id, quiz_id, grade);
                quizGrade.setId(id);
                grades.add(quizGrade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }

        return grades;
    }
    
        public List<QuizGrade> getQuizGradeByQuizId(int quizId) {
        List<QuizGrade> grades = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD); 
                PreparedStatement statement = 
                        connection.prepareStatement("SELECT * FROM quiz_grade WHERE quiz_id = ?")) {
            statement.setInt(1, quizId);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int siswa_id = rs.getInt("siswa_id");
                int quiz_id = rs.getInt("quiz_id");
                float grade = rs.getFloat("grade");
                // Add other fields as needed

                QuizGrade quizGrade = new QuizGrade(siswa_id, quiz_id, grade);
                quizGrade.setId(id);
                grades.add(quizGrade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }

        return grades;
    }
}
