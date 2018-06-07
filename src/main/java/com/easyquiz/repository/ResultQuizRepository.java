package com.easyquiz.repository;


import com.easyquiz.model.ResultQuiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.NamedQuery;
import java.util.List;

/**
 * Created by felleuch on 26/01/2018.
 */
public interface ResultQuizRepository extends JpaRepository<ResultQuiz, Integer> {

    @Modifying
    @Query("update ResultQuiz set note = ?3 ,total = ?4 where  userId= ?2  and  testId = ?1")
    void updateResultQuiz(Integer idTest, int idUser, int nbrCorrect,int total);

    @Query("select e from ResultQuiz e where  e.userId = ?1  and  e.testId = ?2 ")
    ResultQuiz getResultQuizByUserIdAndTestId( int idUser,Integer idTest);


    @Query("select e from ResultQuiz e where    e.testId = ?1 ")
    List<ResultQuiz> getResultQuizByTestId(Integer idTest);
}
