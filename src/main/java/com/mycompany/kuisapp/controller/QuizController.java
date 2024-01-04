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
import com.mycompany.kuisapp.DAO.QuizGradeDAO;
import com.mycompany.kuisapp.DAO.QuizQuestionDAO;
import com.mycompany.kuisapp.DAO.QuizResponseDAO;
import com.mycompany.kuisapp.model.Quiz;
import com.mycompany.kuisapp.model.QuizGrade;
import com.mycompany.kuisapp.model.QuizGuru;
import com.mycompany.kuisapp.model.QuizQuestion;
import com.mycompany.kuisapp.model.QuizResponses;
import java.sql.SQLException;
import java.util.List;

public class QuizController {
    private final QuizDAO quizDAO;
    private final QuizQuestionDAO quizQuestionDAO;
    private final QuizResponseDAO quizResponseDAO;
    private final QuizGradeDAO quizGradeDAO;
    
    public QuizController() {
        this.quizDAO = new QuizDAO();
        this.quizQuestionDAO = new QuizQuestionDAO();
        this.quizResponseDAO = new QuizResponseDAO();
        this.quizGradeDAO = new QuizGradeDAO();
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
    
    public int getStudentAttemptedQuiz(int quizId){
        List<QuizGrade> quizGrade = quizGradeDAO.getQuizGradeByQuizId(quizId);
        
        return quizGrade.size();
    }
    
    public List<QuizQuestion> getQuizQuestion(int quizId){
        return quizQuestionDAO.getQuizQuestion(quizId);
    }
    
    public Quiz getQuizById(int quizId){
        return quizDAO.getQuizById(quizId);
    }
    
    public int saveResponse(QuizResponses response) throws SQLException{
        return quizResponseDAO.addQuizResponse(response);
    }
    
    public int setGrade(QuizGrade grade) throws SQLException{
        return quizGradeDAO.addQuizResponse(grade);
    }
    
    public List<QuizGrade> getAttemptedQuizByStudentId(int siswa_id){
        return quizGradeDAO.getQuizGradeByStudentId(siswa_id);
    }
    // You can add more methods here as needed, such as adding a new quiz, updating a quiz, etc.
}
