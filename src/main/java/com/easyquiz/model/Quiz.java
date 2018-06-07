package com.easyquiz.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by felleuch on 26/01/2018.
 */

@Entity
public class Quiz {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    @Column(name = "user_id")
    int userId;
    @Column(name = "test_id")
    int testId;
    @Column(name = "question_id")
    int questionId;
    @Column(name = "proposition_id")
    int propositionId;


    @Column(name = "response_value")
    String responseValue;


    @Column(name = "bool_response_value")
    boolean boolResponseValue;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getPropositionId() {
        return propositionId;
    }

    public void setPropositionId(int propositionId) {
        this.propositionId = propositionId;
    }

    public String getResponseValue() {
        return responseValue;
    }

    public void setResponseValue(String responseValue) {
        this.responseValue = responseValue;
    }

    public boolean isBoolResponseValue() {
        return boolResponseValue;
    }

    public void setBoolResponseValue(boolean boolResponseValue) {
        this.boolResponseValue = boolResponseValue;
    }
}
