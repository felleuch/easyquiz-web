package com.easyquiz.service;

import com.easyquiz.model.Test;

import java.util.List;

/**
 * Created by felleuch on 22/01/2018.
 */
public interface TestService {
     Test create(Test test) throws Exception;
     Test delete(int id) throws Exception;
     List<Test> findAll();
     Test update(Test test) throws Exception;
     Test findById(int id);
}
