/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kuisapp.DAO;

import com.mycompany.kuisapp.model.Quiz;
import com.mycompany.kuisapp.model.QuizResponses;
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
public class QuizResponseDAO {
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1/kuisApp";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    public int addQuizResponse(QuizResponses response) throws SQLException {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            
            String sql = "INSERT INTO quiz_response (siswa_id, quiz_id, question_id, chosen_answer, is_correct) VALUES (?, ?, ?, ?, ?)";

            
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, response.getSiswa_id());
            ps.setInt(2, response.getQuiz_id());
            ps.setInt(3, response.getQuestion_id());
            ps.setInt(4, response.getChosen_answer());
            ps.setBoolean(5, response.isIs_correct());
            ps.executeUpdate();

            
            ResultSet rs = ps.getGeneratedKeys();
            int responseId = -1;
            if (rs.next()) {
                responseId = rs.getInt(1);
            }
            return responseId;
        }
    }
}
