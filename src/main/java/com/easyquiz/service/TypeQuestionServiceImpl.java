package com.easyquiz.service;



import com.easyquiz.model.TypeQuestion;
import com.easyquiz.repository.TypeQuestionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by felleuch on 23/01/2018.
 */
@Service
public class TypeQuestionServiceImpl implements TypeQuestionService{


    @Resource
    private TypeQuestionRepository typeQuestionRepository;


    @Transactional
    public TypeQuestion create(TypeQuestion typeQuestion) {
        TypeQuestion createdTypeQuestion = typeQuestion;
        return typeQuestionRepository.save(createdTypeQuestion);
    }

    @Override
    @Transactional
    public TypeQuestion findById(int id) {
        return typeQuestionRepository.findOne(id);
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public TypeQuestion delete(int id) throws Exception {
        TypeQuestion deletedTypeQuestion = typeQuestionRepository.findOne(id);

        if (deletedTypeQuestion == null)
            throw new Exception();

        typeQuestionRepository.delete(deletedTypeQuestion);
        return deletedTypeQuestion;
    }

    @Override
    @Transactional
    public List<TypeQuestion> findAll() {
        return typeQuestionRepository.findAll();
    }


    @Transactional(rollbackFor=Exception.class)
    public TypeQuestion update(TypeQuestion typeQuestion) throws Exception {
        TypeQuestion updatedQuestion = typeQuestionRepository.findOne(typeQuestion.getId());

        if (updatedQuestion == null)
            throw new Exception();

        //updatedCategorie.setCode(test.getCode());
        // updatedCategorie.setDescription(test.getDescription());
        return updatedQuestion;
    }

}
