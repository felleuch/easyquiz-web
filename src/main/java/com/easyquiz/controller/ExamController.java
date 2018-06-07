package com.easyquiz.controller;

import com.easyquiz.model.*;
import com.easyquiz.repository.UserRepositoryCustom;
import com.easyquiz.security.UserDetailsServiceImpl;
import com.easyquiz.service.PropositionService;
import com.easyquiz.service.QuizService;
import com.easyquiz.service.ResultQuizService;
import com.easyquiz.service.TestService;
import com.easyquiz.utils.Constants;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FlowEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.io.IOException;

/**
 * Created by felleuch on 24/01/2018.
 */

@Component
@ManagedBean(name = "examController", eager = true)
@SessionScoped
public class ExamController {


    @Autowired
    ResultQuizService resultQuizService;

    @Autowired
    QuizService quizService;

    @Autowired
    TestService testService;

    int numberSecond;

    public int getNumberSecond() {
        return numberSecond;
    }

    public void setNumberSecond(int numberSecond) {
        this.numberSecond = numberSecond;
    }

    @Autowired
    private UserRepositoryCustom userRepository;


    Test currentTest;

    public Test getCurrentTest() {
        return currentTest;
    }

    public void setCurrentTest(Test currentTest) {
        this.currentTest = currentTest;
    }


    public String onFlowProcess(FlowEvent event) {

        return event.getNewStep();

    }


    int currentQuestionNumber;

    public int getCurrentQuestionNumber() {
        return currentQuestionNumber;
    }

    public void setCurrentQuestionNumber(int currentQuestionNumber) {
        this.currentQuestionNumber = currentQuestionNumber;
    }

    public void incrementTime() {
        if (currentTest.isWithTimer()) {
            if (currentQuestionNumber == currentTest.getQuestions().size()) {
                saveExamResult();
             try {
                   FacesContext.getCurrentInstance().getExternalContext().redirect("resultQuiz.jsf?faces-redirect=true");
                    saveExamResult();
               } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                if (numberSecond > 0) {
                    numberSecond--;
                } else {
                    numberSecond = Constants.DUREE_QUESTION;
                    currentQuestionNumber++;
                    RequestContext context = RequestContext.getCurrentInstance();
                    context.execute("PF('myWizard').next();");

                }
            }
        }
    }

    public void nextQuestion(ActionEvent actionEvent) {
        numberSecond = Constants.DUREE_QUESTION;
        currentQuestionNumber++;
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('myWizard').next();");
    }

    ResultQuiz resultQuiz;


    public String saveExamResult() {
        FacesContext facesContext = FacesContext.getCurrentInstance();


        UserDetailsServiceImpl userDetailsServiceImpl = facesContext.getApplication().evaluateExpressionGet(facesContext, "#{userDetailsServiceImpl}", UserDetailsServiceImpl.class);
        User currentUser = userDetailsServiceImpl.getUserConnected();


        Test test = testService.findById(currentTest.getId());
        int nbrTotal = 0;
        int nbrCorrect = 0;
        for (Question q : currentTest.getQuestions()) {

            int res = -1;
            if (q.getTypeQuestionId() == 2) {
                res = Integer.parseInt(q.getSelectedRadioResponseValue());
            }

            int count = 0;
            for (Proposition p : q.getPropositions()) {

                if (q.getTypeQuestionId() == 2) {
                    if (res == count) {
                        p.setBoolResponseValue(true);
                    } else {
                        p.setBoolResponseValue(false);
                    }
                    count++;
                }


                nbrTotal++;
                if (checkReponse(test, p)) {
                    nbrCorrect++;
                    p.setBoolReponseTemp(true);
                } else {
                    p.setBoolReponseTemp(false);
                }
                Quiz quiz = new Quiz();
                quiz.setPropositionId(p.getId());
                quiz.setQuestionId(q.getTypeQuestionId());
                quiz.setTestId(currentTest.getId());
                quiz.setUserId(currentUser.getId());
                quiz.setBoolResponseValue(p.getBoolReponseTemp());
                quiz.setResponseValue(p.getResponseValue());
                quizService.create(quiz);
            }
        }
        resultQuiz = new ResultQuiz();
        resultQuiz.setTestId(test.getId());
        resultQuiz.setUserId(currentUser.getId());
        resultQuiz.setNote(nbrCorrect);
        resultQuiz.setTotal(nbrTotal);
        try {
            resultQuizService.updateResultQuiz(test.getId(), currentUser.getId(), nbrCorrect, nbrTotal);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // RequestContext context = RequestContext.getCurrentInstance();
        //context.execute("PF('po23').start();");


        DashBoardController dashBoardController = facesContext.getApplication().evaluateExpressionGet(facesContext, "#{dashBoardController}", DashBoardController.class);

        dashBoardController.refreshTest();
        return "resultQuiz.jsf?faces-redirect=true";
    }

    public ResultQuiz getResultQuiz() {
        return resultQuiz;
    }

    public void setResultQuiz(ResultQuiz resultQuiz) {
        this.resultQuiz = resultQuiz;
    }

    private boolean checkReponse(Test t, Proposition p) {
        boolean result = true;
        for (Question q : t.getQuestions()) {
            for (Proposition elem : q.getPropositions()) {
                if (elem.getId().intValue() == p.getId().intValue()) {
                    if ((elem.isBoolResponseValue() && !p.isBoolResponseValue()) || (!elem.isBoolResponseValue() && p.isBoolResponseValue())) {
                        result = false;
                    }
                }
            }
        }
        return result;
    }

}
