/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kuisapp.model;

/**
 *
 * @author LUTHFI NOVRA
 */
public class QuizQuestion {
    private int quiz_id;
    private int question_id;

    public int getQuiz_id() {
        return quiz_id;
    }

    public void setQuiz_id(int quiz_id) {
        this.quiz_id = quiz_id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public QuizQuestion(int quiz_id, int question_id) {
        this.quiz_id = quiz_id;
        this.question_id = question_id;
    }
}
