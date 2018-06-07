package com.easyquiz.service;

import com.easyquiz.model.Question;


import java.util.List;

/**
 * Created by felleuch on 22/01/2018.
 */

public interface QuestionService {

     Question create(Question test);
     Question delete(int id) throws Exception;
     List<Question> findAll();
     Question update(Question test) throws Exception;
     Question findById(int id);
}
