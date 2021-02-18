package com.TheMissJ.AnimalTracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TheMissJ.AnimalTracker.models.SubSpecies;
import com.TheMissJ.AnimalTracker.repositories.SubSpeciesRepository;

@Service
public class SubSpeciesService {

	@Autowired
	private SubSpeciesRepository subRepo;
	
	
	public List<SubSpecies> getSub_Species(){
		return this.subRepo.findAll();
		
	}
	
	public SubSpecies getById(Long id) {
		return this.subRepo.findById(id).orElse(null);
	}
	
	public SubSpecies create(SubSpecies sub_species) {
		return this.subRepo.save(sub_species);
	}
	
	public SubSpecies update(SubSpecies sub_species) {
		return this.subRepo.save(sub_species);
		
	}
	
	
	public void deleteSub_Species(Long id) {
		this.subRepo.deleteById(id);
		
	}
	
	
	
	
}
