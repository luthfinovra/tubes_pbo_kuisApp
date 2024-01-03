/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kuisapp.controller;

/**
 *
 * @author LUTHFI NOVRA
 */
import com.mycompany.kuisapp.DAO.QuizDAO;
import com.mycompany.kuisapp.model.Quiz;
import java.util.List;

public class QuizController {
    private final QuizDAO quizDAO;

    public QuizController() {
        this.quizDAO = new QuizDAO();
    }

    public List<Quiz> getQuizzesByTeacherId(int teacherId) {
        return quizDAO.getQuizzesByTeacherId(teacherId);
    }

    // You can add more methods here as needed, such as adding a new quiz, updating a quiz, etc.
}
