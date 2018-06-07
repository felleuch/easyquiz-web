package com.easyquiz.beans;

import com.easyquiz.model.ResultQuiz;
import com.easyquiz.model.Test;

import java.util.Date;
import java.util.List;

/**
 * Created by felleuch on 29/01/2018.
 */
public class TestBean {


    Test test;

    String userName ;

    int note;

    int nbTotalQuestions;

    boolean passed;

    Date dateExam;


    List<ResultQuiz> listResult ;


    public List<ResultQuiz> getListResult() {
        return listResult;
    }

    public void setListResult(List<ResultQuiz> listResult) {
        this.listResult = listResult;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public int getNbTotalQuestions() {
        return nbTotalQuestions;
    }

    public void setNbTotalQuestions(int nbTotalQuestions) {
        this.nbTotalQuestions = nbTotalQuestions;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public Date getDateExam() {
        return dateExam;
    }

    public void setDateExam(Date dateExam) {
        this.dateExam = dateExam;
    }
}
