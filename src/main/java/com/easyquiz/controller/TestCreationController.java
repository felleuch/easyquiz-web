package com.easyquiz.controller;

import com.easyquiz.model.*;
import com.easyquiz.service.*;
import org.apache.commons.io.FilenameUtils;
import org.hibernate.Hibernate;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import javax.faces.event.ActionEvent;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by felleuch on 19/01/2018.
 */
@Component
@ManagedBean(name="testCreationController", eager=true)
@SessionScoped
public class TestCreationController {

    @Autowired
    private CategorieService categorieService;

    @Autowired
    private TypeQuestionService typeQuestionService;

    @Autowired
    private DomaineService domaineService;

    @Autowired
    private DisiplineService disiplineService;

    public DomaineService getDomaineService() {
        return domaineService;
    }

    public void setDomaineService(DomaineService domaineService) {
        this.domaineService = domaineService;
    }


    public TypeQuestionService getTypeQuestionService() {
        return typeQuestionService;
    }

    public void setTypeQuestionService(TypeQuestionService typeQuestionService) {
        this.typeQuestionService = typeQuestionService;
    }

    @Autowired
    private TestService testService;

    private String name;
    private UploadedFile resume;

    public UploadedFile getResume() {
        return resume;
    }

    public void setResume(UploadedFile resume) {
        this.resume = resume;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String uploadResume() throws IOException{

        UploadedFile uploadedPhoto=getResume();
        //System.out.println("Name " + getName());
        //System.out.println("tmp directory" System.getProperty("java.io.tmpdir"));
        //System.out.println("File Name " + uploadedPhoto.getFileName());
        //System.out.println("Size " + uploadedPhoto.getSize());
        String filePath="c:/temp/";
        byte[] bytes=null;

        if (null!=uploadedPhoto) {
            bytes = uploadedPhoto.getContents();
            String filename = FilenameUtils.getName(uploadedPhoto.getFileName());
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath+filename)));
            stream.write(bytes);
            stream.close();
        }

        return "success";
    }

//    public void uploadPhoto(FileUploadEvent e) throws IOException{
//
//        UploadedFile uploadedPhoto=e.getFile();
//
//        String filePath="c:/temp/";
//        byte[] bytes=null;
//
//        if (null!=uploadedPhoto) {
//            bytes = uploadedPhoto.getContents();
//            String filename = FilenameUtils.getName(uploadedPhoto.getFileName());
//            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath+filename)));
//            stream.write(bytes);
//            stream.close();
//        }
//
//        FacesContext.getCurrentInstance().addMessage("messages",new FacesMessage(FacesMessage.SEVERITY_INFO,"Your Photo (File Name "+ uploadedPhoto.getFileName()+ " with size "+ uploadedPhoto.getSize()+ ")  Uploaded Successfully", ""));
//    }

    boolean modeMiseAjour;
    boolean modeCreation;

    public boolean isModeMiseAjour() {
        return modeMiseAjour;
    }

    public void setModeMiseAjour(boolean modeMiseAjour) {
        this.modeMiseAjour = modeMiseAjour;
    }

    public boolean isModeCreation() {
        return modeCreation;
    }

    public void setModeCreation(boolean modeCreation) {
        this.modeCreation = modeCreation;
    }


    Test newTest =new Test();

    Integer selectedCategorieId ;

    Integer selectedDomainId;

    Integer selectedSousDomainId;

    public Integer getSelectedSousDomainId() {
        return selectedSousDomainId;
    }

    public void setSelectedSousDomainId(Integer selectedSousDomainId) {
        this.selectedSousDomainId = selectedSousDomainId;
    }

    public Integer getSelectedDomainId() {
        return selectedDomainId;
    }

    public void setSelectedDomainId(Integer selectedDomainId) {
        this.selectedDomainId = selectedDomainId;
    }

    public Integer getSelectedCategorieId() {
        return selectedCategorieId;
    }

    public void setSelectedCategorieId(Integer selectedCategorieId) {
        this.selectedCategorieId = selectedCategorieId;
    }

    public Test getNewTest() {
        return newTest;
    }

    public void setNewTest(Test newTest) {
        this.newTest = newTest;
    }

    @Autowired
    private QuestionService questionService;

    @Autowired
    private TypeQuestionService questionTypeService;

    String currentQuestionText;






    QuestionBean  newQuestion = new QuestionBean();

    public QuestionBean getNewQuestion() {
        return newQuestion;
    }

    public void setNewQuestion(QuestionBean newQuestion) {
        this.newQuestion = newQuestion;
    }

    public QuestionService getQuestionService() {
        return questionService;
    }

    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }



    List<Question> searchQuestionResultList;

    List<Question>  currentQuestionsList= new ArrayList<Question>();



    boolean modeImageRecherche;

    String libelleRecherche;


    public String getLibelleRecherche() {
        return libelleRecherche;
    }

    public void setLibelleRecherche(String libelleRecherche) {
        this.libelleRecherche = libelleRecherche;
    }

    public boolean isModeImageRecherche() {
        return modeImageRecherche;
    }

    public void setModeImageRecherche(boolean modeImageRecherche) {
        this.modeImageRecherche = modeImageRecherche;
    }


    public CategorieService getCategorieService() {
        return categorieService;
    }

    public void setCategorieService(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    List<Categorie>  allCategories;

    List<TypeQuestion>  allTypeQuestions;

    public List<TypeQuestion> getAllTypeQuestions() {
        return allTypeQuestions;
    }

    public void setAllTypeQuestions(List<TypeQuestion> allTypeQuestions) {
        this.allTypeQuestions = allTypeQuestions;
    }

    List<Domaine>  allDomaines;

    List<Disipline>  allSousDomaines;

    public List<Disipline> getAllSousDomaines() {
        return allSousDomaines;
    }

    public void setAllSousDomaines(List<Disipline> allSousDomaines) {
        this.allSousDomaines = allSousDomaines;
    }

    public List<Domaine> getAllDomaines() {
        return allDomaines;
    }

    public void setAllDomaines(List<Domaine> allDomaines) {
        this.allDomaines = allDomaines;
    }

    public List<Categorie> getAllCategories() {
        return allCategories;
    }

    public void setAllCategories(List<Categorie> allCategories) {
        this.allCategories = allCategories;
    }

    @PostConstruct
    public void init(){
        this.getNewQuestion().getPropositions().add(new Proposition());
        this.getNewQuestion().getPropositions().add(new Proposition());
        this.getNewQuestion().getPropositions().add(new Proposition());
        this.getNewQuestion().getPropositions().add(new Proposition());
        allCategories = categorieService.findAll();
        allDomaines =   domaineService.findAll();
        allSousDomaines = disiplineService.findAll();

        allTypeQuestions = typeQuestionService.findAll();
        currentQuestionText="";
    }

    public List<Question> getSearchQuestionResultList() {
        searchQuestionResultList = questionService.findAll();
        return searchQuestionResultList;
    }

    public void setSearchQuestionResultList(List<Question> searchQuestionResultList) {
        this.searchQuestionResultList = searchQuestionResultList;
    }


    public void searchQuestion(ActionEvent event){
        searchQuestionResultList = questionService.findAll();
    }
    public void addQuestion(Question q){
        currentQuestionsList.add(q);
    }
    public void removeQuestion(int i){
        currentQuestionsList.remove(i);
    }


    public List<Question> getCurrentQuestionsList() {
        return currentQuestionsList;
    }

    public void setCurrentQuestionsList(List<Question> currentQuestionsList) {
        this.currentQuestionsList = currentQuestionsList;
    }

    public void addNewQuestionImage(){

        Question newQ = new Question();

        newQ.setMode(newQuestion.isMode());
        newQ.setImageUrl(resume.getFileName());
        newQ.setMode(newQuestion.isMode());
        newQ.setTypeQuestionId(newQuestion.getTypeQuesionId());
        List<Proposition> lstProposition  = new ArrayList<Proposition>();

        for(Proposition pp:newQuestion.getPropositions()){
            Proposition p = new Proposition();
            p.setText(pp.getText());
            p.setBoolResponseValue(pp.isBoolResponseValue());
            p.setDateCreation(new Date());
            p.setDateMiseAjour(new Date());
            p.setQuestion(newQ);
            p.setResponseValue("YES");
            lstProposition.add(p);

        }

        newQ.setPropositions(lstProposition);
        newQ.setDateCreation(new Date());
        newQ.setDateMiseAjour(new Date());


        //Question questionLastCreatetd = questionService.create(newQ);
        newQ.getTests().add(newTest);
        currentQuestionsList.add(newQ);

    }

    public void addNewQuestion(){
        Question newQ = new Question();
        newQ.setMode(newQuestion.isMode());
        newQ.setDomaineId(newQuestion.getDomaineId());
        newQ.setTypeQuestionId(newQuestion.getTypeQuesionId());
        newQ.setDisiplineId(newQuestion.getDisiplineId());
        List<Proposition> lstProposition  = new ArrayList<Proposition>();
        List<PropositionChoise> lstPropositionChoise  = new ArrayList<PropositionChoise>();

        for(int i=0;i<newQuestion.getNombreProp();i++){
            Proposition p1 =new Proposition();
            lstProposition.add(p1);
        }
        if(newQuestion.getTypeQuesionId()==1) {
            for (int i = 0; i < 5; i++) {
                PropositionChoise p1 = new PropositionChoise();
                lstPropositionChoise.add(p1);
            }
        }


        newQ.setPropositions(lstProposition);
        if(newQuestion.getTypeQuesionId()==1) {
            newQ.setPropositionsChoises(lstPropositionChoise);
        }
        newQ.setDateCreation(new Date());
        newQ.setDateMiseAjour(new Date());
        newQ.getTests().add(newTest);
        currentQuestionsList.add(newQ);
        RequestContext.getCurrentInstance().execute("PF('dlg2').hide()");
    }




    public void saveTest(){
        for(Question q:currentQuestionsList) {
            List<Proposition> pList = new ArrayList<Proposition>();
            List<PropositionChoise> pcList= new ArrayList<>();
            int res = -1;
            if(q.getTypeQuestionId()==2) {
                res = Integer.parseInt(q.getSelectedRadioValue());
            }
            int count=0;
            for(Proposition prop:q.getPropositions()){

                if(q.getTypeQuestionId()==2) {
                    if (res == count) {
                        prop.setBoolResponseValue(true);
                    } else {
                        prop.setBoolResponseValue(false);
                    }
                    count++;
                }

                if(!prop.getText().equals("")) {
                    prop.setQuestion(q);
                    pList.add(prop);
                }
            }
            q.setPropositions(pList);
            q.setDateMiseAjour(new Date());
            q.setDateCreation(new Date());
            if(q.getFileImage()!=null) {
                q.setImageUrl(q.getFileImage().getFileName());
            }
            if(q.getTypeQuestionId()==1){
                for(PropositionChoise propC:q.getPropositionsChoises()){
                    if(!propC.getText().equals("")){
                        propC.setQuestion(q);
                        pcList.add(propC);
                    }
                }
                q.setPropositionsChoises(pcList);
            }
            UploadedFile uploadedPhoto = q.getFileImage();
            uploadImageTo(uploadedPhoto,"C:\\developpement\\iworkspacePerso\\easyquiz-web\\target\\easyquiz-web\\resources\\upload\\");
            uploadImageTo(uploadedPhoto,"C:\\developpement\\iworkspacePerso\\easyquiz-web\\src\\main\\webapp\\resources\\upload\\");
        }

        newTest.setQuestions(currentQuestionsList);
        newTest.setCategorieId(selectedCategorieId);
        newTest.setTypeTestId(1);
        newTest.setDateCreation(new Date());
        newTest.setDateMiseAjour(new Date());
        try {
                if(modeCreation) {
                    testService.create(newTest);
                }
                if(modeMiseAjour){

                        testService.update(newTest);
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        FacesContext facesContext = FacesContext.getCurrentInstance();
        DashBoardController dashBoardController = facesContext.getApplication().evaluateExpressionGet(facesContext, "#{dashBoardController}", DashBoardController.class);
        dashBoardController.refreshTest();
        facesContext.addMessage("container-messages", new                FacesMessage(FacesMessage.SEVERITY_INFO, "Votre test a été enregistré avec succès", "tooto"));
    }

    private void uploadImageTo(UploadedFile uploadedPhoto, String filePath) {

        byte[] bytes = null;
        try {
            if (null != uploadedPhoto) {
                bytes = uploadedPhoto.getContents();
                String filename = FilenameUtils.getName(uploadedPhoto.getFileName());
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath + filename)));
                stream.write(bytes);
                stream.close();
            }

        }catch(IOException e){
            e.printStackTrace();
        }

    }

    public String returnTest(){
        return "/admin/dashboard.jsf";
    }


    public void  onload() {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        try {
            context.redirect(context.getRequestContextPath() + "/admin/dashboard.jsf");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
