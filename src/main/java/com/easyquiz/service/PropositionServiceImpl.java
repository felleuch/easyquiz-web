package com.easyquiz.service;



import com.easyquiz.model.Proposition;
import com.easyquiz.repository.PropositionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by felleuch on 26/01/2018.
 */
@Service
public class PropositionServiceImpl  implements PropositionService{

    @Resource
    private PropositionRepository propositionRepository;


    @Transactional
    public Proposition create(Proposition proposition) {
        Proposition createdproposition = proposition;
        return propositionRepository.save(createdproposition);
    }

    @Override
    @Transactional
    public Proposition findById(int id) {
        return propositionRepository.findOne(id);
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Proposition delete(int id) throws Exception {
        Proposition deletedproposition = propositionRepository.findOne(id);

        if (deletedproposition == null)
            throw new Exception();

        propositionRepository.delete(deletedproposition);
        return deletedproposition;
    }

    @Override
    @Transactional
    public List<Proposition> findAll() {
        return propositionRepository.findAll();
    }


    @Transactional(rollbackFor=Exception.class)
    public Proposition update(Proposition proposition) throws Exception {
        Proposition updatedproposition = propositionRepository.findOne(proposition.getId());
        if (updatedproposition == null)
            throw new Exception();
        updatedproposition.setResponseValue(proposition.getResponseValue());
        return updatedproposition;
    }
}
