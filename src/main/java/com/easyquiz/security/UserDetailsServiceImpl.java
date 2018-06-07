package com.easyquiz.security;

/**
 * Created by felleuch on 25/01/2018.
 */
import com.easyquiz.beans.TestBean;
import com.easyquiz.controller.DashBoardController;
import com.easyquiz.controller.TestCreationController;
import com.easyquiz.controller.UserController;
import com.easyquiz.model.ResultQuiz;
import com.easyquiz.model.Role;
import com.easyquiz.model.Test;
import com.easyquiz.model.User;
import com.easyquiz.repository.TestRepository;
import com.easyquiz.repository.UserRepositoryCustom;
import com.easyquiz.service.IAuthenticationFacade;
import com.easyquiz.service.ResultQuizService;
import org.hibernate.Hibernate;
import org.hibernate.proxy.LazyInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


@Component
@ManagedBean(name="userDetailsServiceImpl")
@SessionScoped
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepositoryCustom userRepository;


    @Autowired
    TestRepository testRepository ;





    @Autowired
    ResultQuizService resultQuizService;

    @Autowired
    private IAuthenticationFacade authenticationFacade;


    User userConnected;

    boolean adminUser=false;

    public boolean isAdminUser() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();

        if(userConnected==null) {
            Authentication authentication = authenticationFacade.getAuthentication();
            if (authentication != null) {
                UserDetailsImpl currentUser = (UserDetailsImpl) authentication.getPrincipal();
                userConnected = userRepository.getUserByUserName(currentUser.getUsername());

                DashBoardController dashBoardController = facesContext.getApplication().evaluateExpressionGet(facesContext, "#{dashBoardController}", DashBoardController.class);
                adminUser = false;
                for (GrantedAuthority grantedAuthority : (HashSet<GrantedAuthority>) currentUser.getAuthorities()) {
                    if (grantedAuthority.getAuthority().equals("ADMIN")) {
                        adminUser = true;
                        request.getSession().setAttribute("ISADMIN", "admin");
                    }
                }
                List<TestBean> tbList = getTestBeans(facesContext);
                dashBoardController.setAllTests(tbList);
            }
        }
        return adminUser;
    }

    public List<TestBean> getTestBeans(FacesContext facesContext) {
        List<Test> tests = new ArrayList<>();
        List<TestBean> tbList = new ArrayList<>();
        if(adminUser) {
            List users = userRepository.findAllUsers();
            UserController userController = facesContext.getApplication().evaluateExpressionGet(facesContext, "#{userController}", UserController.class);
            userController.setAllUsers(users);
            tests = testRepository.findAll();
            List<ResultQuiz> rqList=new ArrayList<>();
            for(Test t:tests){
                TestBean tb = new TestBean();

                try {
                    rqList = resultQuizService.getResultQuizByTestId( t.getId());

                    for(ResultQuiz elem:rqList){
                        User u = userRepository.getUserById(elem.getUserId()) ;
                        elem.setUsername(u.getUsername());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                tb.setListResult(rqList);
                tb.setTest(t);
                tbList.add(tb);
            }
        }else {
            tests = userConnected.getTests();
            for (Test t : tests) {
                TestBean tb = new TestBean();
                ResultQuiz rq = null;
                try {
                    rq = resultQuizService.getResultQuizByUserIdAndTestId(userConnected.getId(), t.getId());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                tb.setTest(t);
                tb.setUserName(userConnected.getUsername());
                tb.setNote(rq.getNote());
                if (rq.getNote() >= 0) {
                    tb.setPassed(true);
                } else {
                    tb.setPassed(false);
                }
                tb.setNbTotalQuestions(rq.getTotal());
                tb.setDateExam(rq.getDateUpdate());
                tbList.add(tb);
            }
        }
        return tbList;
    }

    public void setAdminUser(boolean adminUser) {
        this.adminUser = adminUser;
    }

    public User getUserConnected() {
        return userConnected;
    }

    public void setUserConnected(User userConnected) {
        this.userConnected = userConnected;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails matchingUser = userRepository.trouverToutUserAvecUserName(username);
        if (matchingUser == null) {
            throw new UsernameNotFoundException("Username or password incorrect!");
        }
        return matchingUser;
    }
}
