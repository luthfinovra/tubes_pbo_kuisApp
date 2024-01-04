/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kuisapp.model;

/**
 *
 * @author LUTHFI NOVRA
 */
public class QuizGuru {
    private Quiz quiz;
    private String namaGuru; // Add other teacher details if needed

    public QuizGuru(Quiz quiz, String nama) {
        this.quiz = quiz;
        this.namaGuru = nama;
    }

    // Getters for quiz and teacher details
    public Quiz getQuiz() {
        return quiz;
    }

    public String getNamaGuru() {
        return namaGuru;
    }
}
