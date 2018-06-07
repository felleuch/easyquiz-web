package com.easyquiz.service;


import com.easyquiz.model.Proposition;
import com.easyquiz.model.Question;
import com.easyquiz.repository.QuestionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by felleuch on 22/01/2018.
 */
@Service
public class QuestionServiceImpl implements QuestionService{

    @Resource
    private QuestionRepository questionRepository;


    @Transactional
    public Question create(Question question) {
        Question createdquestion = question;
//        for(Proposition p:createdquestion.getPropositions()){
//            p.setId(null);
//        }
        return questionRepository.save(createdquestion);
    }

    @Override
    @Transactional
    public Question findById(int id) {
        return questionRepository.findOne(id);
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Question delete(int id) throws Exception {
        Question deletedQuestion = questionRepository.findOne(id);

        if (deletedQuestion == null)
            throw new Exception();

        questionRepository.delete(deletedQuestion);
        return deletedQuestion;
    }

    @Override
    @Transactional
    public List<Question> findAll() {
        return questionRepository.findAll();
    }


    @Transactional(rollbackFor=Exception.class)
    public Question update(Question question) throws Exception {
        Question updatedQuestion = questionRepository.findOne(question.getId());

        if (updatedQuestion == null)
            throw new Exception();

        //updatedCategorie.setCode(test.getCode());
        // updatedCategorie.setDescription(test.getDescription());
        return updatedQuestion;
    }
}
