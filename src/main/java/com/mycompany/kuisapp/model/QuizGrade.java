/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kuisapp.model;

/**
 *
 * @author LUTHFI NOVRA
 */
public class QuizGrade {
    private int id;
    private int siswa_id;
    private int quiz_id;
    private float grade;

    public QuizGrade(int siswa_id, int quiz_id, float grade) {
        this.siswa_id = siswa_id;
        this.quiz_id = quiz_id;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }
    
    
}
