package com.easyquiz.service;

import com.easyquiz.model.ResultQuiz;
import com.easyquiz.repository.ResultQuizRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;


/**
 * Created by felleuch on 26/01/2018.
 */
@Service
public class ResultQuizServiceImpl implements ResultQuizService{

    @Resource
    private ResultQuizRepository resultQuizRepository;

    @Override
    @Transactional
    public ResultQuiz create(ResultQuiz resultQuiz) {
        ResultQuiz createdResultQuiz = resultQuiz;
        return resultQuizRepository.save(createdResultQuiz);
    }

    @Override
    @Transactional
    public ResultQuiz findById(int id) {
        return resultQuizRepository.findOne(id);
    }



    @Override
    @Transactional(rollbackFor=Exception.class)
    public ResultQuiz delete(int id) throws Exception {
        ResultQuiz deletedShop = resultQuizRepository.findOne(id);

        if (deletedShop == null)
            throw new Exception();

        resultQuizRepository.delete(deletedShop);
        return deletedShop;
    }

    @Override
    @Transactional
    public List<ResultQuiz> findAll() {
        return resultQuizRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public ResultQuiz update(ResultQuiz resultQuiz) throws Exception {
        ResultQuiz updatedResultQuiz = resultQuizRepository.findOne(resultQuiz.getId());

        if (updatedResultQuiz == null)
            throw new Exception();

        updatedResultQuiz.setNote(resultQuiz.getNote());
        updatedResultQuiz.setTotal(resultQuiz.getTotal());
        return updatedResultQuiz;
    }



    @Override
    @Transactional(rollbackFor=Exception.class)
    public void updateResultQuiz(Integer idTest, int idUser, int nbrCorrect,int total) throws Exception {


         resultQuizRepository.updateResultQuiz( idTest,  idUser,  nbrCorrect,total);

    }

   public  ResultQuiz getResultQuizByUserIdAndTestId(int idUser,Integer idTest)throws Exception {
        return resultQuizRepository.getResultQuizByUserIdAndTestId(idUser ,idTest );
   }

    @Override
    public List<ResultQuiz> getResultQuizByTestId( Integer idTest) throws Exception {
        return resultQuizRepository.getResultQuizByTestId(idTest );
    }
}
