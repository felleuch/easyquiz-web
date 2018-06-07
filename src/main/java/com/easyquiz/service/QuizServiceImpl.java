package com.easyquiz.service;



import com.easyquiz.model.Quiz;
import com.easyquiz.repository.QuizRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by felleuch on 26/01/2018.
 */
@Service
public class QuizServiceImpl implements QuizService{

    @Resource
    private QuizRepository quizRepository;


    @Transactional
    public Quiz create(Quiz quiz) {
        Quiz createdQuiz = quiz;
        return quizRepository.save(createdQuiz);
    }

    @Override
    @Transactional
    public Quiz findById(int id) {
        return quizRepository.findOne(id);
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Quiz delete(int id) throws Exception {
        Quiz deletedQuiz = quizRepository.findOne(id);

        if (deletedQuiz == null)
            throw new Exception();

        quizRepository.delete(deletedQuiz);
        return deletedQuiz;
    }

    @Override
    @Transactional
    public List<Quiz> findAll() {
        return quizRepository.findAll();
    }


    @Transactional(rollbackFor=Exception.class)
    public Quiz update(Quiz quiz) throws Exception {
        Quiz updatedquiz = quizRepository.findOne(quiz.getId());
        if (updatedquiz == null)
            throw new Exception();

        return updatedquiz;
    }
}
