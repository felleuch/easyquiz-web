package com.easyquiz.service;


import com.easyquiz.model.TypeQuestion;

import java.util.List;

/**
 * Created by felleuch on 23/01/2018.
 */
public interface TypeQuestionService {
     TypeQuestion create(TypeQuestion typeQuestion);
     TypeQuestion delete(int id) throws Exception;
     List<TypeQuestion> findAll();
     TypeQuestion update(TypeQuestion categorie) throws Exception;
     TypeQuestion findById(int id);
}
