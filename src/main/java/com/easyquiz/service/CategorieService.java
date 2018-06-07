package com.easyquiz.service;


import com.easyquiz.model.Categorie;

import java.util.List;

public interface CategorieService {
	 Categorie create(Categorie categorie);
	 Categorie delete(int id) throws Exception;
	 List<Categorie> findAll();
	 Categorie update(Categorie categorie) throws Exception;
	 Categorie findById(int id);
}
