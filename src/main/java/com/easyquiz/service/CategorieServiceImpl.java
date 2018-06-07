package com.easyquiz.service;

import com.easyquiz.exception.ShopNotFound;
import com.easyquiz.model.Categorie;
import com.easyquiz.repository.CategorieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategorieServiceImpl implements CategorieService {
	
	@Resource
	private CategorieRepository categorieRepository;

	@Override
	@Transactional
	public Categorie create(Categorie shop) {
		Categorie createdShop = shop;
		return categorieRepository.save(createdShop);
	}
	
	@Override
	@Transactional
	public Categorie findById(int id) {
		return categorieRepository.findOne(id);
	}

	@Override
	@Transactional(rollbackFor=ShopNotFound.class)
	public Categorie delete(int id) throws ShopNotFound {
		Categorie deletedShop = categorieRepository.findOne(id);
		
		if (deletedShop == null)
			throw new ShopNotFound();

		categorieRepository.delete(deletedShop);
		return deletedShop;
	}

	@Override
	@Transactional
	public List<Categorie> findAll() {
		return categorieRepository.findAll();
	}

	@Override
	@Transactional(rollbackFor=ShopNotFound.class)
	public Categorie update(Categorie categorie) throws ShopNotFound {
		Categorie updatedCategorie = categorieRepository.findOne(categorie.getId());
		
		if (updatedCategorie == null)
			throw new ShopNotFound();
		
		updatedCategorie.setCode(categorie.getCode());
		updatedCategorie.setDescription(categorie.getDescription());
		return updatedCategorie;
	}

}
