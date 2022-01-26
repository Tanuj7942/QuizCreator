/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.quizcreator;

import com.mycompany.quizcreator.beans.Question;
import com.mycompany.quizcreator.questiondatabase.QuestionDatabase;
import java.util.List;

/**
 *
 * @author 23379
 */
public class ViewQuestion extends javax.swing.JInternalFrame {

    /**
     * Creates new form ViewQuestion
     */
    List<Question> allQuestions = null;
    int questionNumber;

    public ViewQuestion(int selectedID) {
        initComponents();
        QuestionDatabase database = new QuestionDatabase();
        allQuestions = database.getQuestions(null);
        int lowestQuestionCount=0;
        int highestQuestionCount=allQuestions.size()-1;
        while(lowestQuestionCount<=highestQuestionCount){
            int middleValue = (lowestQuestionCount+highestQuestionCount)/2;
            if(allQuestions.get(middleValue).getQuestionID()==selectedID){
                //System.out.println(middleValue);
                questionID.setText(String.valueOf(allQuestions.get(middleValue).getQuestionID()));
                question.setText(allQuestions.get(middleValue).getQuestion());
                firstOption.setText(allQuestions.get(middleValue).getFirstOption());
                secondOption.setText(allQuestions.get(middleValue).getSecondOption());
                thirdOption.setText(allQuestions.get(middleValue).getThirdOption());
                fourthOption.setText(allQuestions.get(middleValue).getFourthOption());

                if (allQuestions.get(middleValue).getCorrectOption().equals(allQuestions.get(middleValue).getFirstOption())) {
                    firstCorrectOption.setSelected(true);
                } else if (allQuestions.get(middleValue).getCorrectOption().equals(allQuestions.get(middleValue).getSecondOption())) {
                    secondCorrectOption.setSelected(true);
                } else if (allQuestions.get(middleValue).getCorrectOption().equals(allQuestions.get(middleValue).getThirdOption())) {
                    thirdCorrectOption.setSelected(true);
                } else if (allQuestions.get(middleValue).getCorrectOption().equals(allQuestions.get(middleValue).getFourthOption())) {
                    fourthCorrectOption.setSelected(true);
                }
                questionNumber = middleValue;
                questionCount.setText((questionNumber + 1) + "/" + allQuestions.size());
                break;
            } 
            if(allQuestions.get(middleValue).getQuestionID()>selectedID){
                highestQuestionCount=middleValue-1;
                continue;
            } else {
                lowestQuestionCount=middleValue+1;
                continue;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        answersCheckbox = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        questionID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        question = new javax.swing.JTextArea();
        firstOption = new javax.swing.JTextField();
        secondOption = new javax.swing.JTextField();
        thirdOption = new javax.swing.JTextField();
        fourthOption = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        firstQuestion = new javax.swing.JButton();
        previousQuestion = new javax.swing.JButton();
        nextQuestion = new javax.swing.JButton();
        lastQuestion = new javax.swing.JButton();
        questionCount = new javax.swing.JTextField();
        firstCorrectOption = new javax.swing.JCheckBox();
        secondCorrectOption = new javax.swing.JCheckBox();
        fourthCorrectOption = new javax.swing.JCheckBox();
        thirdCorrectOption = new javax.swing.JCheckBox();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("View");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Question ID");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Question");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("Option");

        questionID.setEditable(false);

        question.setEditable(false);
        question.setColumns(20);
        question.setLineWrap(true);
        question.setRows(5);
        question.setWrapStyleWord(true);
        jScrollPane1.setViewportView(question);

        firstOption.setEditable(false);
        firstOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstOptionActionPerformed(evt);
            }
        });

        secondOption.setEditable(false);

        thirdOption.setEditable(false);
        thirdOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thirdOptionActionPerformed(evt);
            }
        });

        fourthOption.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("First Option");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Second Option");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Third Option");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Fourth Option");

        firstQuestion.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        firstQuestion.setText("<<");
        firstQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstQuestionActionPerformed(evt);
            }
        });

        previousQuestion.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        previousQuestion.setText("<");
        previousQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousQuestionActionPerformed(evt);
            }
        });

        nextQuestion.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        nextQuestion.setText(">");
        nextQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextQuestionActionPerformed(evt);
            }
        });

        lastQuestion.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lastQuestion.setText(">>");
        lastQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastQuestionActionPerformed(evt);
            }
        });

        questionCount.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        questionCount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        questionCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionCountActionPerformed(evt);
            }
        });

        answersCheckbox.add(firstCorrectOption);
        firstCorrectOption.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        firstCorrectOption.setText("Correct Answer");
        firstCorrectOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstCorrectOptionActionPerformed(evt);
            }
        });

        answersCheckbox.add(secondCorrectOption);
        secondCorrectOption.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        secondCorrectOption.setText("Correct Answer");

        answersCheckbox.add(fourthCorrectOption);
        fourthCorrectOption.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        fourthCorrectOption.setText("Correct Answer");

        answersCheckbox.add(thirdCorrectOption);
        thirdCorrectOption.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        thirdCorrectOption.setText("Correct Answer");
        thirdCorrectOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thirdCorrectOptionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(questionID, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(secondOption)
                            .addComponent(firstOption)
                            .addComponent(thirdOption)
                            .addComponent(fourthOption, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(secondCorrectOption)
                            .addComponent(firstCorrectOption)
                            .addComponent(thirdCorrectOption)
                            .addComponent(fourthCorrectOption))))
                .addContainerGap(53, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(488, 488, 488))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(firstQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(previousQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(questionCount, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(nextQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(lastQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(questionID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addGap(147, 147, 147))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel5)
                                                .addComponent(firstOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(29, 29, 29)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel6)
                                                .addComponent(secondOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(28, 28, 28)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel7)
                                                .addComponent(thirdOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(24, 24, 24)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel8)
                                                .addComponent(fourthOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(firstCorrectOption)
                                        .addGap(27, 27, 27)
                                        .addComponent(secondCorrectOption)
                                        .addGap(28, 28, 28)
                                        .addComponent(thirdCorrectOption)
                                        .addGap(22, 22, 22)
                                        .addComponent(fourthCorrectOption))))
                            .addComponent(jLabel3))
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firstQuestion)
                            .addComponent(previousQuestion)
                            .addComponent(nextQuestion)
                            .addComponent(lastQuestion)
                            .addComponent(questionCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(89, 89, 89))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void questionCountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionCountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_questionCountActionPerformed

    private void firstOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstOptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstOptionActionPerformed

    private void thirdOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thirdOptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_thirdOptionActionPerformed

    private void firstCorrectOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstCorrectOptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstCorrectOptionActionPerformed

    private void thirdCorrectOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thirdCorrectOptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_thirdCorrectOptionActionPerformed

    private void nextQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextQuestionActionPerformed
        // TODO add your handling code here:
        questionNumber = questionNumber + 1;
        if (questionNumber == allQuestions.size()) {
            questionNumber = 0;
        }
        setQuestion(questionNumber);
    }//GEN-LAST:event_nextQuestionActionPerformed

    private void previousQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousQuestionActionPerformed
        // TODO add your handling code here:
        questionNumber = questionNumber - 1;
        if (questionNumber == -1) {
            questionNumber = allQuestions.size() - 1;
        }
        setQuestion(questionNumber);
    }//GEN-LAST:event_previousQuestionActionPerformed

    private void lastQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastQuestionActionPerformed
        // TODO add your handling code here:
        setQuestion(questionNumber = allQuestions.size() - 1);
    }//GEN-LAST:event_lastQuestionActionPerformed

    private void firstQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstQuestionActionPerformed
        // TODO add your handling code here:
        setQuestion(questionNumber = 0);
    }//GEN-LAST:event_firstQuestionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup answersCheckbox;
    private javax.swing.JCheckBox firstCorrectOption;
    private javax.swing.JTextField firstOption;
    private javax.swing.JButton firstQuestion;
    private javax.swing.JCheckBox fourthCorrectOption;
    private javax.swing.JTextField fourthOption;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lastQuestion;
    private javax.swing.JButton nextQuestion;
    private javax.swing.JButton previousQuestion;
    private javax.swing.JTextArea question;
    private javax.swing.JTextField questionCount;
    private javax.swing.JTextField questionID;
    private javax.swing.JCheckBox secondCorrectOption;
    private javax.swing.JTextField secondOption;
    private javax.swing.JCheckBox thirdCorrectOption;
    private javax.swing.JTextField thirdOption;
    // End of variables declaration//GEN-END:variables

    private void setQuestion(int questionNumber) {
        questionCount.setText((questionNumber + 1) + "/" + allQuestions.size());
        questionID.setText(String.valueOf(allQuestions.get(questionNumber).getQuestionID()));
        question.setText(allQuestions.get(questionNumber).getQuestion());
        firstOption.setText(allQuestions.get(questionNumber).getFirstOption());
        secondOption.setText(allQuestions.get(questionNumber).getSecondOption());
        thirdOption.setText(allQuestions.get(questionNumber).getThirdOption());
        fourthOption.setText(allQuestions.get(questionNumber).getFourthOption());

        if (allQuestions.get(questionNumber).getCorrectOption().equals(allQuestions.get(questionNumber).getFirstOption())) {
            firstCorrectOption.setSelected(true);
        } else if (allQuestions.get(questionNumber).getCorrectOption().equals(allQuestions.get(questionNumber).getSecondOption())) {
            secondCorrectOption.setSelected(true);
        } else if (allQuestions.get(questionNumber).getCorrectOption().equals(allQuestions.get(questionNumber).getThirdOption())) {
            thirdCorrectOption.setSelected(true);
        } else if (allQuestions.get(questionNumber).getCorrectOption().equals(allQuestions.get(questionNumber).getFourthOption())) {
            fourthCorrectOption.setSelected(true);
        }
    }
}