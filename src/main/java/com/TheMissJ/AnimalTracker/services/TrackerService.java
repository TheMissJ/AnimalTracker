package com.TheMissJ.AnimalTracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TheMissJ.AnimalTracker.models.Tracker;
import com.TheMissJ.AnimalTracker.repositories.TrackerRepository;

@Service
public class TrackerService {

	@Autowired
	private TrackerRepository tRepo;
	
	
	public List<Tracker> getTrackers(){
		return this.tRepo.findAll();
		
	}
	
	public Tracker getById(Long id) {
		return this.tRepo.findById(id).orElse(null);
	}
	
	public Tracker create(Tracker tracker) {
		return this.tRepo.save(tracker);
	}
	
	public Tracker update(Tracker tracker) {
		return this.tRepo.save(tracker);
		
	}
	
	
	public void deleteTracker(Long id) {
		this.tRepo.deleteById(id);
		
	}
	
	
	
}
