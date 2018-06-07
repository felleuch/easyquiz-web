package com.easyquiz.service;

import com.easyquiz.exception.ShopNotFound;
import com.easyquiz.model.Categorie;
import com.easyquiz.model.Test;
import com.easyquiz.repository.CategorieRepository;
import com.easyquiz.repository.TestRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by felleuch on 22/01/2018.
 */


@Service
public class TestServiceImpl implements TestService{

    @Resource
    private TestRepository testRepository;


    @Transactional
    public Test create(Test test) {
        Test createdTest = test;
        return testRepository.save(createdTest);
    }

    @Override
    @Transactional
    public Test findById(int id) {
        return testRepository.findOne(id);
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Test delete(int id) throws Exception {
        Test deletedShop = testRepository.findOne(id);

        if (deletedShop == null)
            throw new ShopNotFound();

        testRepository.delete(deletedShop);
        return deletedShop;
    }

    @Override
    @Transactional
    public List<Test> findAll() {
        return testRepository.findAll();
    }


    @Transactional(rollbackFor=Exception.class)
    public Test update(Test test) throws Exception {
        testRepository.save(test);
        Test updatedTest = testRepository.findOne(test.getId());
        if (updatedTest == null)
            throw new Exception();
        return updatedTest;
    }
}
