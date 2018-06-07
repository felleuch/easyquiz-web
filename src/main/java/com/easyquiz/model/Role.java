package com.easyquiz.model;
// Generated May 31, 2017 3:23:15 PM by Hibernate Tools 4.3.1


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Role  implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
     private int id;


    @Column(name="name", nullable=false, length=50)
     private String name;

    @ManyToMany(mappedBy = "roles",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
     private List<User> users = new ArrayList<>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}


