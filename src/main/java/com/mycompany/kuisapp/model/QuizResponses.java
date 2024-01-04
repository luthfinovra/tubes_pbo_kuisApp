/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kuisapp.model;

/**
 *
 * @author LUTHFI NOVRA
 */
public class QuizResponses {
    private int id;
    private int siswa_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private int quiz_id;
    private int question_id;
    private int chosen_answer;
    private boolean is_correct;

    public int getSiswa_id() {
        return siswa_id;
    }

    public void setSiswa_id(int siswa_id) {
        this.siswa_id = siswa_id;
    }

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

    public int getChosen_answer() {
        return chosen_answer;
    }

    public void setChosen_answer(int chosen_answer) {
        this.chosen_answer = chosen_answer;
    }

    public boolean isIs_correct() {
        return is_correct;
    }

    public void setIs_correct(boolean is_correct) {
        this.is_correct = is_correct;
    }

    public QuizResponses(int siswa_id, int quiz_id, int question_id, int chosen_answer, boolean is_correct) {
        this.siswa_id = siswa_id;
        this.quiz_id = quiz_id;
        this.question_id = question_id;
        this.chosen_answer = chosen_answer;
        this.is_correct = is_correct;
    }
}
