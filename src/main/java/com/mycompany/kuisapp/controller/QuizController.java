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
import com.mycompany.kuisapp.DAO.QuizQuestionDAO;
import com.mycompany.kuisapp.model.Quiz;
import com.mycompany.kuisapp.model.QuizGuru;
import com.mycompany.kuisapp.model.QuizQuestion;
import java.sql.SQLException;
import java.util.List;

public class QuizController {
    private final QuizDAO quizDAO;
    private final QuizQuestionDAO quizQuestionDAO;

    public QuizController() {
        this.quizDAO = new QuizDAO();
        this.quizQuestionDAO = new QuizQuestionDAO();
    }

    public List<QuizGuru> getAllQuizzez(){
        return quizDAO.getAllQuizzes();
    }
    
    public List<Quiz> getQuizzesByTeacherId(int teacherId) {
        return quizDAO.getQuizzesByTeacherId(teacherId);
    }

    public int createNewQuiz(Quiz quiz) throws SQLException{
        return quizDAO.addQuiz(quiz);
    }
    
    public boolean associateQuizQuestion(int quizId, int questionId) throws SQLException{
        return quizQuestionDAO.addQuizQuestion(quizId, questionId);
    }
    
    public boolean deleteQuizById(int quizId){
        return quizDAO.deleteQuizById(quizId);
    }
    
    public int getQuestionAmount(int quizId){
        List<QuizQuestion> quizQuestions = quizQuestionDAO.getQuizQuestion(quizId);
        
        return quizQuestions.size();
    }
    
    public List<QuizQuestion> getQuizQuestion(int quizId){
        return quizQuestionDAO.getQuizQuestion(quizId);
    }
    
    public Quiz getQuizById(int quizId){
        return quizDAO.getQuizById(quizId);
    }
    // You can add more methods here as needed, such as adding a new quiz, updating a quiz, etc.
}
