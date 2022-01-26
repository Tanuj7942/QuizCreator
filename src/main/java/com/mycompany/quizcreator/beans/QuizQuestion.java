/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quizcreator.beans;

/**
 *
 * @author 23379
 */
public class QuizQuestion extends Question {

    private boolean correct;
    private String userSelectedOption;

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public String getUserSelectedOption() {
        return userSelectedOption;
    }

    public void setUserSelectedOption(String userSelectedOption) {
        this.userSelectedOption = userSelectedOption;
        if (getCorrectOption().equals(this.userSelectedOption)) {
            setCorrect(true);
        } else {
            setCorrect(false);
        }
    }
}
