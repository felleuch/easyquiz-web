package com.easyquiz.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by felleuch on 19/01/2018.
 */
@Entity
public class Societe {
    private long id;
    private long version;
    private Timestamp dateMiseAjour;
    private String code;
    private Timestamp dateCreation;
    private String description;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "version")
    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @Basic
    @Column(name = "date_mise_ajour")
    public Timestamp getDateMiseAjour() {
        return dateMiseAjour;
    }

    public void setDateMiseAjour(Timestamp dateMiseAjour) {
        this.dateMiseAjour = dateMiseAjour;
    }

    @Basic
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "date_creation")
    public Timestamp getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Timestamp dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Societe societe = (Societe) o;

        if (id != societe.id) return false;
        if (version != societe.version) return false;
        if (dateMiseAjour != null ? !dateMiseAjour.equals(societe.dateMiseAjour) : societe.dateMiseAjour != null)
            return false;
        if (code != null ? !code.equals(societe.code) : societe.code != null) return false;
        if (dateCreation != null ? !dateCreation.equals(societe.dateCreation) : societe.dateCreation != null)
            return false;
        if (description != null ? !description.equals(societe.description) : societe.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (version ^ (version >>> 32));
        result = 31 * result + (dateMiseAjour != null ? dateMiseAjour.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (dateCreation != null ? dateCreation.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
