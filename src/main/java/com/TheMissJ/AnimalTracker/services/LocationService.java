package com.TheMissJ.AnimalTracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TheMissJ.AnimalTracker.models.Location;
import com.TheMissJ.AnimalTracker.repositories.LocationRepository;

@Service
public class LocationService {

	@Autowired
	private LocationRepository lRepo;
	
	
	public List<Location> getLocations(){
		return this.lRepo.findAll();
		
	}
	
	public Location getById(Long id) {
		return this.lRepo.findById(id).orElse(null);
	}
	
	public Location create(Location location) {
		return this.lRepo.save(location);
	}
	
	public Location update(Location location) {
		return this.lRepo.save(location);
		
	}
	
	
	public void deleteLocation(Long id) {
		this.lRepo.deleteById(id);
		
	}
}
