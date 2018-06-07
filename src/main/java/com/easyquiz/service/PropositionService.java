package com.easyquiz.service;



import com.easyquiz.model.Proposition;

import java.util.List;

/**
 * Created by felleuch on 26/01/2018.
 */
public interface PropositionService {

    Proposition create(Proposition proposition);
    Proposition delete(int id) throws Exception;
    List<Proposition> findAll();
    Proposition update(Proposition test) throws Exception;
    Proposition findById(int id);


}
