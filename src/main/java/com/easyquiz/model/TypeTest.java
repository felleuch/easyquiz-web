package com.easyquiz.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by felleuch on 19/01/2018.
 */
@Entity
@Table(name = "type_test")
public class TypeTest {
    private long id;
    private long version;
    private Date dateMiseAjour;
    private String code;
    private Date dateCreation;
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
    public Date getDateMiseAjour() {
        return dateMiseAjour;
    }

    public void setDateMiseAjour(Date dateMiseAjour) {
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
    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
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

        TypeTest typeTest = (TypeTest) o;

        if (id != typeTest.id) return false;
        if (version != typeTest.version) return false;
        if (dateMiseAjour != null ? !dateMiseAjour.equals(typeTest.dateMiseAjour) : typeTest.dateMiseAjour != null)
            return false;
        if (code != null ? !code.equals(typeTest.code) : typeTest.code != null) return false;
        if (dateCreation != null ? !dateCreation.equals(typeTest.dateCreation) : typeTest.dateCreation != null)
            return false;
        if (description != null ? !description.equals(typeTest.description) : typeTest.description != null)
            return false;

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
