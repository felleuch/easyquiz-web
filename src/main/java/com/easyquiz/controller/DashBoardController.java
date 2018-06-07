package com.easyquiz.controller;

import com.easyquiz.beans.TestBean;
import com.easyquiz.model.*;
import com.easyquiz.repository.TestRepository;
import com.easyquiz.repository.UserRepositoryCustom;
import com.easyquiz.security.GrantedAuthorityImpl;
import com.easyquiz.security.UserDetailsImpl;
import com.easyquiz.security.UserDetailsServiceImpl;
import com.easyquiz.service.IAuthenticationFacade;
import com.easyquiz.service.ResultQuizService;
import com.easyquiz.service.TestService;
import com.easyquiz.utils.Constants;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


/**
 * Created by felleuch on 22/01/2018.
 */


@Component
@ManagedBean
@RequestScoped
public class DashBoardController {



    @Autowired
    TestRepository testRepository ;

    TestBean selectedTestBean;

    public TestBean getSelectedTestBean() {
        return selectedTestBean;
    }

    public void setSelectedTestBean(TestBean selectedTestBean) {
        this.selectedTestBean = selectedTestBean;
    }

    @Autowired
    private TestService testService;


    @Autowired
    ResultQuizService resultQuizService;

    String pageLoad;

    @Autowired
    private IAuthenticationFacade authenticationFacade;


    UserDetailsImpl currentUser;


public void selectTest(TestBean t){
    selectedTestBean =t;


    RequestContext.getCurrentInstance().execute("PF('dlgResult').show()");
}


    public UserDetailsImpl getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(UserDetailsImpl currentUser) {
        this.currentUser = currentUser;
    }

    List<TestBean> allTests;

    Test selectedTest;



    public void setPageLoad(String pageLoad) {
        this.pageLoad = pageLoad;
    }

    public Test getSelectedTest() {
        return selectedTest;
    }

    public void setSelectedTest(Test selectedTest) {
        this.selectedTest = selectedTest;
    }

    public TestService getTestService() {
        return testService;
    }

    public void setTestService(TestService testService) {
        this.testService = testService;
    }


    public List<TestBean> getAllTests() {
        return allTests;
    }

    public void setAllTests(List<TestBean> allTests) {
        this.allTests = allTests;
    }

    @PostConstruct
    public void init(){
        //allTests = testService.findAll();
    }


    public void viewTest(Test t){

    }

    public String updateTest(TestBean t){



        FacesContext facesContext = FacesContext.getCurrentInstance();
        TestCreationController testCreationController = facesContext.getApplication().evaluateExpressionGet(facesContext, "#{testCreationController}", TestCreationController.class);

        testCreationController.newTest = t.getTest();
        testCreationController.setCurrentQuestionsList(t.getTest().getQuestions());
        testCreationController.setModeCreation(false);
        testCreationController.setModeMiseAjour(true);
        return "/secured/quiz.jsf";

    }




    public String addTest(){


        FacesContext facesContext = FacesContext.getCurrentInstance();
        TestCreationController testCreationController = facesContext.getApplication().evaluateExpressionGet(facesContext, "#{testCreationController}", TestCreationController.class);
        testCreationController.setNewTest(new Test());
        testCreationController.setNewQuestion(new QuestionBean());
        testCreationController.getNewQuestion().getPropositions().add(new Proposition());
        testCreationController.getNewQuestion().getPropositions().add(new Proposition());
        testCreationController.getNewQuestion().getPropositions().add(new Proposition());
        testCreationController.getNewQuestion().getPropositions().add(new Proposition());
        testCreationController.setModeCreation(true);
        testCreationController.setModeMiseAjour(false);

        testCreationController.setCurrentQuestionsList(new ArrayList<Question>());
        return "/secured/quiz.jsf";
    }

    public void deleteTest(TestBean t){
        try {
            testService.delete(t.getTest().getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

        refreshTest();

    }
    public void refreshTest() {
        FacesContext facesContext = FacesContext.getCurrentInstance();

        UserDetailsServiceImpl userDetailsServiceImpl = facesContext.getApplication().evaluateExpressionGet(facesContext, "#{userDetailsServiceImpl}", UserDetailsServiceImpl.class);
        UserController userController = facesContext.getApplication().evaluateExpressionGet(facesContext, "#{userController}", UserController.class);

        List<TestBean> tbList = userDetailsServiceImpl.getTestBeans(facesContext);
        userController.refreshTest();
        this.setAllTests(tbList);
    }


    public String lancerTest(TestBean tb){

       // RequestContext context = RequestContext.getCurrentInstance();
       // context.execute("PF('po23').start();");

        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExamController examController = facesContext.getApplication().evaluateExpressionGet(facesContext, "#{examController}", ExamController.class);
        examController.setNumberSecond(Constants.DUREE_QUESTION);
        examController.setCurrentQuestionNumber(0);
        for(Question q:tb.getTest().getQuestions()){
            for(Proposition p: q.getPropositions()){
               p.setBoolResponseValue(false);
               p.setResponseValue("");
            }
        }
        examController.setCurrentTest(tb.getTest());
        return "/secured/exam.jsf";
    }
}
