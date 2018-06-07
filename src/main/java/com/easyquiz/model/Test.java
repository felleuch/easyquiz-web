package com.easyquiz.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by felleuch on 19/01/2018.
 */
@Entity
public class Test {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;




    @Column(name = "statut")
    private boolean statut;


    @Column(name = "date_mise_ajour")
    private Date dateMiseAjour;


    @Column(name = "name")
    private String name;

    @Column(name = "date_creation")
    private Date dateCreation;




    @Column(name = "with_timer")
    boolean withTimer;


    public boolean isWithTimer() {
        return withTimer;
    }

    public void setWithTimer(boolean withTimer) {
        this.withTimer = withTimer;
    }

    @ManyToMany(fetch=FetchType.EAGER,cascade =
            {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REFRESH})
    @JoinTable(name = "test_question",
            joinColumns = {
                    @JoinColumn(
                            name = "id_test",
                            referencedColumnName = "id"
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "id_question",
                            referencedColumnName = "id"
                    )
            }
    )
    List<Question> questions ;


    @Column(name="categorie_id")
    private int categorieId;

    @Column(name="type_test_id")
    private int typeTestId;

    public int getTypeTestId() {
        return typeTestId;
    }

    public void setTypeTestId(int typeTestId) {
        this.typeTestId = typeTestId;
    }

    public int getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(int categorieId) {
        this.categorieId = categorieId;
    }


    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
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



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }



}
