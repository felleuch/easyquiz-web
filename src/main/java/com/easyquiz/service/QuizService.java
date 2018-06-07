package com.easyquiz.service;



import com.easyquiz.model.Quiz;

import java.util.List;

/**
 * Created by felleuch on 26/01/2018.
 */
public interface QuizService {
    Quiz create(Quiz quiz);
    Quiz delete(int id) throws Exception;
    List<Quiz> findAll();
    Quiz update(Quiz quiz) throws Exception;
    Quiz findById(int id);
}
