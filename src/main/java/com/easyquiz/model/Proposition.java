package com.easyquiz.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by felleuch on 19/01/2018.
 */
@Entity
public class Proposition {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "text")
    private String text;


    @Column(name = "response_value")
    private String responseValue;


    @Column(name = "bool_response_value")
    private boolean boolResponseValue;



    @Column(name = "date_mise_ajour")
    private Date dateMiseAjour;


    @Column(name = "date_creation")
    private Date dateCreation;


    @ManyToOne
    private Question question;





    @Transient
    private boolean boolReponseTemp;



    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Date getDateMiseAjour() {
        return dateMiseAjour;
    }

    public void setDateMiseAjour(Date dateMiseAjour) {
        this.dateMiseAjour = dateMiseAjour;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
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




    public boolean getBoolReponseTemp() {
        return boolReponseTemp;
    }

    public void setBoolReponseTemp(boolean boolReponseTemp) {
        this.boolReponseTemp = boolReponseTemp;
    }
}
