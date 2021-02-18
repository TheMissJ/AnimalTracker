package com.TheMissJ.AnimalTracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TheMissJ.AnimalTracker.models.Giraffe;
import com.TheMissJ.AnimalTracker.repositories.GiraffeRepository;
import com.TheMissJ.AnimalTracker.repositories.ConGroupRepository;
import com.TheMissJ.AnimalTracker.repositories.LocationRepository;
import com.TheMissJ.AnimalTracker.repositories.SpeciesRepository;
import com.TheMissJ.AnimalTracker.repositories.TrackerRepository;
import com.TheMissJ.AnimalTracker.repositories.UserRepository;

@Service
public class GiraffeService {

	@Autowired
	private GiraffeRepository gRepo;
	
//	@ Autowired 
//	private UserRepository uRepo;
//	
//	@Autowired
//	private ConGroupRepository cRepo;
//	
//	@Autowired
//	private LocationRepository lRepo;
//	
//	@Autowired
//	private TrackerRepository tRepo;
//	
//	@Autowired
//	private SpeciesRepository sRepo;
//	
	
	
	public List<Giraffe> getGiraffes(){
		return this.gRepo.findAll();
		
	}
	
	public Giraffe getById(Long id) {
		return this.gRepo.findById(id).orElse(null);
	}
	
	public Giraffe create(Giraffe giraffe) {
		return this.gRepo.save(giraffe);
	}
	
	public Giraffe update(Giraffe giraffe) {
		return this.gRepo.save(giraffe);
		
	}
	
	
	public void deleteGiraffe(Long id) {
		this.gRepo.deleteById(id);
		
	}
	
	
	
}
