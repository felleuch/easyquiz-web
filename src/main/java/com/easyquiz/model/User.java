package com.easyquiz.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;


@Entity        
public class User  implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
     private int id;

    @Column(name="first_name", nullable=false, length=50)
     private String firstName;


    @ManyToMany(fetch=FetchType.LAZY,cascade =
            {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REFRESH})
    @JoinTable(name = "result_quiz",
            joinColumns = {
                    @JoinColumn(
                            name = "user_id",
                            referencedColumnName = "id"
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "test_id",
                            referencedColumnName = "id"
                    )
            }
    )
    List<Test> tests;

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    @Column(name="last_name", nullable=false, length=50)
     private String lastName;


    @Column(name="email", nullable=false, length=50)
     private String email;


    @Column(name="user_name", nullable=false, length=50)
     private String username;


    @Column(name="password", nullable=false, length=100)
     private String password;

    @Column(name="enabled", nullable=false)
    private Boolean enabled;


    @ManyToMany(fetch=FetchType.EAGER,cascade =
            {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REFRESH})
    @JoinTable(name = "user_role",
            joinColumns = {
                    @JoinColumn(
                            name = "id_user",
                            referencedColumnName = "id"
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "id_role",
                            referencedColumnName = "id"
                    )
            }
    )
     private List<Role> roles = new ArrayList<Role>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    

    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    

   public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}



    public Boolean getEnabled() {
        return true;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }


    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}


