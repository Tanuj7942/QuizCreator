/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quizcreator.beans;

/**
 *
 * @author 23379
 */
public class TestSettings extends Exception {

    private int totalQuestions;
    private int noOfQuestions;
    private int marksForEachQuestion;
    private int minimumPassingMarks;

    public int getNoOfQuestions() {
        return noOfQuestions;
    }

    public void setNoOfQuestions(int noOfQuestions) {
        this.noOfQuestions = noOfQuestions;
    }

    public int getMarksForEachQuestion() {
        return marksForEachQuestion;
    }

    public void setMarksForEachQuestion(int marksForEachQuestion) {
        this.marksForEachQuestion = marksForEachQuestion;
    }

    public int getMinimumPassingMarks() {
        return minimumPassingMarks;
    }

    public void setMinimumPassingMarks(int minimumPassingMarks) {
        this.minimumPassingMarks = minimumPassingMarks;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

}
