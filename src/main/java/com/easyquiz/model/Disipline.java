package com.easyquiz.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by felleuch on 23/02/2018.
 */
@Entity
public class Disipline {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")

    private Integer id;

    @Column(name = "date_mise_ajour")
    private Date dateMiseAjour;

    @Column(name = "code")
    private String code;

    @Column(name = "date_creation")
    private Date dateCreation;

    @Column(name = "description")
    private String description;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne
    private Domaine domaine;

    public Domaine getDomaine() {
        return domaine;
    }

    public void setDomaine(Domaine domaine) {
        this.domaine = domaine;
    }



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateMiseAjour() {
        return dateMiseAjour;
    }

    public void setDateMiseAjour(Date dateMiseAjour) {
        this.dateMiseAjour = dateMiseAjour;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
}
