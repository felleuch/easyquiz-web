package com.easyquiz.controller;

import com.easyquiz.model.Proposition;
import org.primefaces.model.UploadedFile;

import javax.persistence.Column;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by felleuch on 23/01/2018.
 */
public class QuestionBean {

    int  typeQuesionId;

    String textQuestion;

    boolean mode;

    int nombreProp=1;

    private int domaineId;

    private int disiplineId;

    public int getDomaineId() {
        return domaineId;
    }

    public void setDomaineId(int domaineId) {
        this.domaineId = domaineId;
    }

    public int getDisiplineId() {
        return disiplineId;
    }

    public void setDisiplineId(int disiplineId) {
        this.disiplineId = disiplineId;
    }

    public int getNombreProp() {
        return nombreProp;
    }

    public void setNombreProp(int nombreProp) {
        this.nombreProp = nombreProp;
    }

    boolean rep;

    String repRadio;



    UploadedFile fileImage;

    public UploadedFile getFileImage() {
        return fileImage;
    }

    public void setFileImage(UploadedFile fileImage) {
        this.fileImage = fileImage;
    }



    public String getRepRadio() {
        return repRadio;
    }

    public void setRepRadio(String repRadio) {
        this.repRadio = repRadio;
    }

    public boolean isRep() {
        return rep;
    }

    public void setRep(boolean rep) {
        this.rep = rep;
    }


    List<Proposition> propositions=new ArrayList<Proposition>();


    public List<Proposition> getPropositions() {
        return propositions;
    }

    public void setPropositions(List<Proposition> propositions) {
        this.propositions = propositions;
    }

    public int getTypeQuesionId() {
        return typeQuesionId;
    }

    public void setTypeQuesionId(int typeQuesionId) {
        this.typeQuesionId = typeQuesionId;
    }

    public String getTextQuestion() {
        return textQuestion;
    }

    public void setTextQuestion(String textQuestion) {
        this.textQuestion = textQuestion;
    }

    public boolean isMode() {
        return mode;
    }

    public void setMode(boolean mode) {
        this.mode = mode;
    }


}
