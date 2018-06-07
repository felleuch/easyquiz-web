package com.easyquiz.controller;

import com.easyquiz.model.Role;
import com.easyquiz.model.Test;
import com.easyquiz.model.User;
import com.easyquiz.repository.UserRepositoryCustom;
import com.easyquiz.service.TestService;
import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by felleuch on 29/01/2018.
 */
@Component
@ManagedBean(name="testCreationController", eager=true)
@SessionScoped
public class UserController {


    @Autowired
    private UserRepositoryCustom userRepository;

    @Autowired
    private TestService testService;



    DualListModel<Test> tests;

    DualListModel<Role> roles;


    public DualListModel<Test> getTests() {
        return tests;
    }

    public void setTests(DualListModel<Test> tests) {
        this.tests = tests;
    }

    public DualListModel<Role> getRoles() {
        return roles;
    }

    public void setRoles(DualListModel<Role> roles) {
        this.roles = roles;
    }

    List<Role> rolesSource;
    List<Role> rolesTarget;

    List<Test> testsSource;
    List<Test> testsTarget;



    @PostConstruct
    public void init() {
        rolesSource = userRepository.findAllRoles();
        testsSource = testService.findAll();
    }


    public void refreshTest(){
        testsSource = testService.findAll();
    }



    List allUsers;

    User userModify;


    public User getUserModify() {
        return userModify;
    }

    public void setUserModify(User userModify) {
        this.userModify = userModify;
    }

    public List getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(List allUsers) {
        this.allUsers = allUsers;
    }


    public void addUser(){

    }


    public void deleteUser(User u){

    }

    public String  updateUser(User user){


        userModify=userRepository.getUserByUserName(user.getUsername());


        rolesTarget = user.getRoles();
        testsTarget = userModify.getTests();
        roles =  new DualListModel<Role>(rolesSource, rolesTarget);
        tests =   new DualListModel<Test>(testsSource, testsTarget);


        return "/admin/userUpdate.jsf";
    }

    public void onTransfer(TransferEvent event) {
        StringBuilder builder = new StringBuilder();
        for(Object item : event.getItems()) {
            builder.append(((Role) item).getName()).append("<br />");
        }

       FacesMessage msg = new FacesMessage();
//        msg.setSeverity(FacesMessage.SEVERITY_INFO);
//        msg.setSummary("Items Transferred");
//        msg.setDetail(builder.toString());
//
//        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public String updateUserModifed(){
        userModify.setTests(tests.getTarget());
        userModify.setRoles(roles.getTarget());

        userRepository.updateUser(userModify);
        allUsers = userRepository.findAllUsers();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage("container-messages", new                FacesMessage(FacesMessage.SEVERITY_INFO, "Utilisateur enregistré avec succès", "tooto"));

        return "/admin/userUpdate.jsf";
    }
public String cancel(){
    return "/admin/users.jsf";
}


}
