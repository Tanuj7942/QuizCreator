/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quizcreator.questiondatabase;

import com.mycompany.quizcreator.AdminPanel;
import com.mycompany.quizcreator.beans.Question;
import com.mycompany.quizcreator.beans.QuizQuestion;
import com.mycompany.quizcreator.beans.TestSettings;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import javafx.beans.binding.Bindings;
import javax.swing.JOptionPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author 23379
 */
public class QuestionDatabase {

    private static final Logger LOG = LogManager.getLogger(QuestionDatabase.class);

    public boolean addQuestion(Question question) throws SQLIntegrityConstraintViolationException {
        boolean status = false;
        byte[] byteArray = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizCreator", "root", "7942");
            LOG.info("Connection Created");
            Statement stmt = conn.createStatement();
            String command = "insert into questions values(" + question.getQuestionID()
                    + ",'" + question.getQuestion()
                    + "','" + question.getFirstOption()
                    + "','" + question.getSecondOption()
                    + "','" + question.getThirdOption()
                    + "','" + question.getFourthOption()
                    + "','" + question.getCorrectOption() + "')";
            stmt.executeUpdate(command);
            conn.close();
            LOG.info("Connection Disconnected" + "\n");
            status = true;

        } catch (ClassNotFoundException ex) {
            LOG.error(ex + "\n");
        } catch (SQLIntegrityConstraintViolationException ex) {
            throw ex;
        } catch (SQLException ex) {
            LOG.error(ex + "\n");
        } catch (InstantiationException ex) {
            LOG.error(ex + "\n");
        } catch (IllegalAccessException ex) {
            LOG.error(ex + "\n");
        }
        return status;
    }

    public List<Question> getQuestions(Question criteriaQuestion) {

        List<Question> questions = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizCreator", "root", "7942");
            LOG.info("Connection Created");
            Statement stmt = conn.createStatement();
        
            String command = "select * from questions where ";
            if (criteriaQuestion != null) {
                if (criteriaQuestion.getQuestionID() != 0) {
                    command = command + "question_id=" + criteriaQuestion.getQuestionID() + " or ";
                }
                if (criteriaQuestion.getQuestion() != null && !criteriaQuestion.getQuestion().equals("")) {
                    command = command + "question like '%" + criteriaQuestion.getQuestion() + "%' or ";
                }
                if (criteriaQuestion.getFirstOption() != null && !criteriaQuestion.getFirstOption().equals("")) {
                    command = command + "first_option like '%" + criteriaQuestion.getFirstOption() + "%' or ";
                }
                if (criteriaQuestion.getSecondOption() != null && !criteriaQuestion.getSecondOption().equals("")) {
                    command = command + "second_option like '%" + criteriaQuestion.getSecondOption() + "%' or ";
                }
                if (criteriaQuestion.getThirdOption() != null && !criteriaQuestion.getThirdOption().equals("")) {
                    command = command + "third_option like '%" + criteriaQuestion.getThirdOption() + "%' or ";
                }
                if (criteriaQuestion.getFourthOption() != null && !criteriaQuestion.getFourthOption().equals("")) {
                    command = command + "fourth_option like '%" + criteriaQuestion.getFourthOption() + "%' or ";
                }
            }
            if ((command.substring(command.length() - 4)).equals(" or ")) {
                command = command.substring(0, (command.length() - 4));
            } else {
                command = "select * from questions";
            }
        
            ResultSet result = stmt.executeQuery(command);
            questions = new ArrayList<Question>();
            while (result.next()) {
                QuizQuestion question = new QuizQuestion();
                question.setQuestionID(result.getInt(1));
                question.setQuestion(result.getString(2));
                question.setFirstOption(result.getString(3));
                question.setSecondOption(result.getString(4));
                question.setThirdOption(result.getString(5));
                question.setFourthOption(result.getString(6));
                question.setCorrectOption(result.getString(7));
            
                questions.add(question);
            }
            conn.close();
            LOG.info("Connection Disconnected");
        } catch (ClassNotFoundException ex) {
            LOG.error(ex);
        } catch (InstantiationException ex) {
            LOG.error(ex);
        } catch (IllegalAccessException ex) {
            LOG.error(ex);
        } catch (SQLException ex) {
            LOG.error(ex);
        }
        return questions;
    }

    public boolean updateQuestion(Question question) {
        boolean status = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizCreator", "root", "7942");
            LOG.info("Connection Created");
            Statement stmt = conn.createStatement();

            String command = "update questions set question='"
                    + question.getQuestion() + "', first_option='"
                    + question.getFirstOption() + "', second_option='"
                    + question.getSecondOption() + "', third_option='"
                    + question.getThirdOption() + "', fourth_option='"
                    + question.getFourthOption() + "', correct_option='"
                    + question.getCorrectOption() + "' where question_id="
                    + question.getQuestionID();
            stmt.executeUpdate(command);
            conn.close();
            LOG.info("Connection Disconnected");
            status = true;
        } catch (ClassNotFoundException ex) {
            LOG.error(ex);
        } catch (InstantiationException ex) {
            LOG.error(ex);
        } catch (IllegalAccessException ex) {
            LOG.error(ex);
        } catch (SQLException ex) {
            LOG.error(ex);
        }
        return status;
    }

    public boolean deleteQuestions(List<Integer> listOfIDs) {
        boolean status = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizCreator", "root", "7942");
            LOG.info("Connection Created");
            Statement stmt = conn.createStatement();

            String command = "delete from questions where question_id in(";
            for (int i = 0; i < listOfIDs.size(); i++) {
                command = command + listOfIDs.get(i);
                if (i != (listOfIDs.size() - 1)) {
                    command = command + ",";
                }
            }
            command = command + ")";
            stmt.executeUpdate(command);
            conn.close();
            LOG.info("Connection Disconnected");
            status = true;

        } catch (ClassNotFoundException ex) {
            LOG.error(ex);
        } catch (InstantiationException ex) {
            LOG.error(ex);
        } catch (IllegalAccessException ex) {
            LOG.error(ex);
        } catch (SQLException ex) {
            LOG.error(ex);
        }
        return status;
    }

    public void setTestSettings(TestSettings settings) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizCreator", "root", "7942");
            LOG.info("Connection Created");
            Statement stmt = conn.createStatement();
            String getCommand = "select * from test_settings";
            ResultSet result = stmt.executeQuery(getCommand);
            String command;
            if (result.next()) {
                command = "update test_settings set total_questions=" + settings.getTotalQuestions()
                        + ", no_of_questions=" + settings.getNoOfQuestions()
                        + ", marks_for_each_question=" + settings.getMarksForEachQuestion()
                        + ", minimum_marks=" + settings.getMinimumPassingMarks() + ";";
            } else {
                command = "insert into test_settings values ("
                        + settings.getTotalQuestions() + ","
                        + settings.getNoOfQuestions() + ","
                        + settings.getMarksForEachQuestion() + ","
                        + settings.getMinimumPassingMarks() + ");";
            }
            stmt.executeUpdate(command);
            conn.close();
            LOG.info("Connection Disconnected");
        } catch (ClassNotFoundException ex) {
            LOG.error(ex);
        } catch (InstantiationException ex) {
            LOG.error(ex);
        } catch (IllegalAccessException ex) {
            LOG.error(ex);
        } catch (SQLException ex) {
            LOG.error(ex);
        }
    }

    public TestSettings getTestSettings() {
        TestSettings settings = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizCreator", "root", "7942");
            LOG.info("Connection Created");
            Statement stmt = conn.createStatement();

            String command = "select * from test_settings";
            ResultSet result = stmt.executeQuery(command);

            result.next();

            settings = new TestSettings();
            settings.setTotalQuestions(result.getInt(1));
            settings.setNoOfQuestions(result.getInt(2));
            settings.setMarksForEachQuestion(result.getInt(3));
            settings.setMinimumPassingMarks(result.getInt(4));

            conn.close();
            LOG.info("Connection Disconnected");
        } catch (ClassNotFoundException ex) {
            LOG.error(ex);
        } catch (InstantiationException ex) {
            LOG.error(ex);
        } catch (IllegalAccessException ex) {
            LOG.error(ex);
        } catch (SQLException ex) {
            LOG.error(ex);
        }
        return settings;
    }
}
