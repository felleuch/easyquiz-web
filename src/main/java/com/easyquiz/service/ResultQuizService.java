package com.easyquiz.service;



import com.easyquiz.model.ResultQuiz;

import java.util.List;

/**
 * Created by felleuch on 26/01/2018.
 */
public interface ResultQuizService  {
    ResultQuiz create(ResultQuiz resultQuiz) throws Exception;
    ResultQuiz delete(int id) throws Exception;
    List<ResultQuiz> findAll();
    ResultQuiz update(ResultQuiz resultQuiz) throws Exception;
    ResultQuiz findById(int id);

    void updateResultQuiz(Integer id, int id1, int nbrCorrect,int total) throws Exception;

    ResultQuiz getResultQuizByUserIdAndTestId(int idUser,   Integer idTest) throws Exception;

    List<ResultQuiz> getResultQuizByTestId(Integer id1)throws  Exception;
}
