package com.easyquiz.controller;

import com.easyquiz.model.Categorie;
import com.easyquiz.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.bean.ManagedBean;
import java.util.List;

/**
 * Created by felleuch on 19/01/2018.
 */

@ManagedBean
public class CategorieController {



    @Autowired
	private CategorieService categorieService;


    List<Categorie> getAllCategorie(){
        return categorieService.findAll();
    }



}
