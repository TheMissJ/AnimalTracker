package com.TheMissJ.AnimalTracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TheMissJ.AnimalTracker.models.Species;
import com.TheMissJ.AnimalTracker.repositories.SpeciesRepository;
import com.TheMissJ.AnimalTracker.repositories.SubSpeciesRepository;

@Service
public class SpeciesService {

	@Autowired
	private SpeciesRepository sRepo;
	
	@Autowired
	private SubSpeciesRepository subRepo;
	
	
	
	public List<Species> getSpeciess(){
		return this.sRepo.findAll();
		
	}
	
	
	public Species getById(Long id) {
		return this.sRepo.findById(id).orElse(null);
	}
	
	public Species create(Species species) {
		return this.sRepo.save(species);
	}
	
	public Species update(Species species) {
		return this.sRepo.save(species);
		
	}
	
	
	public void deleteSpecies(Long id) {
		this.sRepo.deleteById(id);
		
	}


	public Object getSubSpecies(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
