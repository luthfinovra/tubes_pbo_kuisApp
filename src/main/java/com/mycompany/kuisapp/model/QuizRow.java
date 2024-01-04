/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kuisapp.model;

/**
 *
 * @author LUTHFI NOVRA
 */
public class QuizRow {
    private boolean selected;
    private int questionId;
    private String questionText;

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    
    // Constructors, getters, and setters

    public QuizRow(boolean selected, int questionId, String questionText) {
        this.selected = selected;
        this.questionId = questionId;
        this.questionText = questionText;
    }
}
