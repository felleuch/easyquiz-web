package com.easyquiz.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by felleuch on 26/01/2018.
 */
@Entity
@Table(name = "result_quiz")
public class ResultQuiz {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    @Column(name = "user_id")
    int userId;

    @Transient
    String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "test_id")
    int testId;

    @Column(name = "note")
    int note;

    @Column(name = "total")
    int total;

    @Column(name="date_creation")
    Date dateCreation;


    @Column(name="date_update")
    Date dateUpdate;


    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
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





}
