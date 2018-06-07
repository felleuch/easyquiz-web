package com.easyquiz.service;

import com.easyquiz.model.Domaine;

import java.util.List;

/**
 * Created by felleuch on 23/02/2018.
 */
public interface DomaineService {
    Domaine create(Domaine domaine);
    Domaine delete(int id) throws Exception;
    List<Domaine> findAll();
    Domaine update(Domaine domaine) throws Exception;
    Domaine findById(int id);
}
