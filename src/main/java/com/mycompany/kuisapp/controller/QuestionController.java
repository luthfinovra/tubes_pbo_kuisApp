/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kuisapp.controller;

import com.mycompany.kuisapp.DAO.QuestionDAO;
import com.mycompany.kuisapp.model.Question;
import java.util.List;

/**
 *
 * @author LUTHFI NOVRA
 */
public class QuestionController {
    private final QuestionDAO questionDAO;

    public QuestionController() {
        this.questionDAO = new QuestionDAO();
    }
    
    public int addNewQuestion(Question question, int teacherId){
        return questionDAO.addQuestion(question, teacherId);
    }

    public List<Question> getQuestionsByTeacherId(int teacherId) {
        return questionDAO.getQuestionByTeacherId(teacherId);
    }
    
    public boolean deleteQuestionById(int questionId){
        return questionDAO.deleteQuestionById(questionId);
    }
}
