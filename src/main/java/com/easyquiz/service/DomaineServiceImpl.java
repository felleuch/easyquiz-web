package com.easyquiz.service;

import com.easyquiz.exception.ShopNotFound;
import com.easyquiz.model.Domaine;
import com.easyquiz.repository.DomaineRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DomaineServiceImpl implements DomaineService {
	
	@Resource
	private DomaineRepository domaineRepository;

	@Override
	@Transactional
	public Domaine create(Domaine domaine) {
		Domaine createdDomaine = domaine;
		return domaineRepository.save(createdDomaine);
	}
	
	@Override
	@Transactional
	public Domaine findById(int id) {
		return domaineRepository.findOne(id);
	}

	@Override
	@Transactional(rollbackFor=ShopNotFound.class)
	public Domaine delete(int id) throws ShopNotFound {
		Domaine deletedDomaine = domaineRepository.findOne(id);
		
		if (deletedDomaine == null)
			throw new ShopNotFound();

		domaineRepository.delete(deletedDomaine);
		return deletedDomaine;
	}

	@Override
	@Transactional
	public List<Domaine> findAll() {
		return domaineRepository.findAll();
	}

	@Override
	@Transactional(rollbackFor=ShopNotFound.class)
	public Domaine update(Domaine domaine) throws ShopNotFound {
		Domaine updatedDomaine = domaineRepository.findOne(domaine.getId());
		
		if (updatedDomaine == null)
			throw new ShopNotFound();

		updatedDomaine.setCode(domaine.getCode());
		updatedDomaine.setDescription(domaine.getDescription());
		return updatedDomaine;
	}

}
