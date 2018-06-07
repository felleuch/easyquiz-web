package com.easyquiz.controller;

import com.easyquiz.model.User;
import com.easyquiz.repository.UserRepositoryCustom;
import com.easyquiz.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by felleuch on 25/01/2018.
 */

@Component
@ManagedBean
public class RegistrationController {


    User newUser=new User();

    String confirmPassword;


    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public User getNewUser() {
        return newUser;
    }

    public void setNewUser(User newUser) {
        this.newUser = newUser;
    }

    @Autowired
    private UserRepositoryCustom userRepository;


    public UserRepositoryCustom getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepositoryCustom userRepository) {
        this.userRepository = userRepository;
    }

    public void saveNewUser(){


        User createdUser = userRepository.saveNewUser(newUser);
        if(createdUser==null){
            // afficher error
        }
    }

    /**
     * Logout operation.
     * @return
     */
    public String doLogout() {
        // Set the paremeter indicating that user is logged in to false
        //loggedIn = false;

        // Set logout message
        FacesMessage msg = new FacesMessage("Logout success!", "INFO MSG");
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, msg);

        return "/login/jsf";
    }



    public String logout(){
        SecurityContextHolder.clearContext();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        UserDetailsServiceImpl userDetailsServiceImpl = facesContext.getApplication().evaluateExpressionGet(facesContext, "#{userDetailsServiceImpl}", UserDetailsServiceImpl.class);

        userDetailsServiceImpl.setUserConnected(null);

        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        request.getSession().setAttribute("ISADMIN", "");


        return "/login.jsf";
    }

}
