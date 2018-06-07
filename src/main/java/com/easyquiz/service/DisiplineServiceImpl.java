package com.easyquiz.service;

import com.easyquiz.exception.ShopNotFound;
import com.easyquiz.model.Disipline;
import com.easyquiz.repository.DisiplineRepository;
import com.easyquiz.repository.DomaineRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DisiplineServiceImpl implements DisiplineService {
	
	@Resource
	private DisiplineRepository disiplineRepository;

	@Override
	@Transactional
	public Disipline create(Disipline disipline) {
		Disipline createdDisipline = disipline;
		return disiplineRepository.save(createdDisipline);
	}
	
	@Override
	@Transactional
	public Disipline findById(int id) {
		return disiplineRepository.findOne(id);
	}

	@Override
	@Transactional(rollbackFor=ShopNotFound.class)
	public Disipline delete(int id) throws ShopNotFound {
		Disipline deletedDisipline = disiplineRepository.findOne(id);
		
		if (deletedDisipline == null)
			throw new ShopNotFound();

		disiplineRepository.delete(deletedDisipline);
		return deletedDisipline;
	}

	@Override
	@Transactional
	public List<Disipline> findAll() {
		return disiplineRepository.findAll();
	}

	@Override
	@Transactional(rollbackFor=ShopNotFound.class)
	public Disipline update(Disipline disipline) throws ShopNotFound {
		Disipline updatedDisipline = disiplineRepository.findOne(disipline.getId());
		
		if (updatedDisipline == null)
			throw new ShopNotFound();

		updatedDisipline.setCode(disipline.getCode());
		updatedDisipline.setDescription(disipline.getDescription());
		return updatedDisipline;
	}

}
