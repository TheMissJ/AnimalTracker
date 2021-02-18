package com.TheMissJ.AnimalTracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TheMissJ.AnimalTracker.models.ConGroup;
import com.TheMissJ.AnimalTracker.repositories.ConGroupRepository;
import com.TheMissJ.AnimalTracker.repositories.UserRepository;

@Service
public class ConGroupService {

	@Autowired
	private ConGroupRepository cRepo;

	@Autowired 
	private UserRepository uRepo;
	
	
	public List<ConGroup> getGroups(){
		return this.cRepo.findAll();
		
	}
	
	public ConGroup getById(Long id) {
		return this.cRepo.findById(id).orElse(null);
	}
	
	public ConGroup create(ConGroup conGroup) {
		return this.cRepo.save(conGroup);
	}
	
	public ConGroup update(ConGroup conGroup) {
		return this.cRepo.save(conGroup);
		
	}
	
	
	public void deleteGroup(Long id) {
		this.cRepo.deleteById(id);
		
	}
	
	
	
	
}
