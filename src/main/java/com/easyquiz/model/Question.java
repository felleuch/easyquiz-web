package com.easyquiz.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.primefaces.model.UploadedFile;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by felleuch on 19/01/2018.
 */
@Entity
public class Question {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    @Transient
    UploadedFile fileImage;

    public UploadedFile getFileImage() {
        return fileImage;
    }

    public void setFileImage(UploadedFile fileImage) {
        this.fileImage = fileImage;
    }

    @Column(name = "statut")
    private boolean statut;

    @Column(name = "date_mise_ajour")
    private Date dateMiseAjour;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "mode")
    private boolean mode;

    @Column(name = "text")
    private String text;



    @Column(name = "date_creation")
    private Date dateCreation;

    @Column(name="type_question_id")
    private int typeQuestionId;

    @Column(name="domaine_id")
    private int domaineId;


    @Column(name="disipline_id")
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

    @ManyToMany(mappedBy = "questions",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Test> tests = new ArrayList<>();

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    @OneToMany(fetch=FetchType.EAGER,mappedBy = "question", cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Proposition> propositions =new ArrayList<>();


    @OneToMany(fetch=FetchType.EAGER,mappedBy = "question", cascade = CascadeType.ALL)
    private List<PropositionChoise> propositionsChoises =new ArrayList<>();




    public List<PropositionChoise> getPropositionsChoises() {
        return propositionsChoises;
    }

    public void setPropositionsChoises(List<PropositionChoise> propositionsChoises) {
        this.propositionsChoises = propositionsChoises;
    }

    public List<String> getPropositionChoisesList() {
        List<String> tempLst= new ArrayList<>();
        for(PropositionChoise p:propositionsChoises){
            tempLst.add(p.getText());
        }
        return tempLst;
    }

    public List<String> getPropositionList() {
        List<String> tempLst= new ArrayList<>();
        int k=0;
        for(Proposition p:propositions){
                tempLst.add(String.valueOf(k));
                k++;
        }
        return tempLst;
    }

    @Transient
    String selectedRadioResponseValue;

    public String getSelectedRadioResponseValue() {
        return selectedRadioResponseValue;
    }

    public void setSelectedRadioResponseValue(String selectedRadioResponseValue) {
        this.selectedRadioResponseValue = selectedRadioResponseValue;
    }

    @Column(name="selected_radio_value")
    String selectedRadioValue;


    public String getSelectedRadioValue() {
        return selectedRadioValue;
    }

    public void setSelectedRadioValue(String selectedRadioValue) {
        this.selectedRadioValue = selectedRadioValue;
    }

    public List <Proposition> getPropositions() {
        return propositions;
    }

    public void setPropositions(List<Proposition> propositions) {
        this.propositions = propositions;
    }

    public int getTypeQuestionId() {
        return typeQuestionId;
    }

    public void setTypeQuestionId(int typeQuestionId) {
        this.typeQuestionId = typeQuestionId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }





    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }



    public Date getDateMiseAjour() {
        return dateMiseAjour;
    }

    public void setDateMiseAjour(Date dateMiseAjour) {
        this.dateMiseAjour = dateMiseAjour;
    }



    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }



    public boolean isMode() {
        return mode;
    }

    public void setMode(boolean mode) {
        this.mode = mode;
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




}
