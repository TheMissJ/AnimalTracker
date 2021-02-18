package com.TheMissJ.AnimalTracker.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.TheMissJ.AnimalTracker.models.Location;
import com.TheMissJ.AnimalTracker.repositories.LocationRepository;

@Component
public class LocationValidator {

	@Autowired
	private LocationRepository lRepo;
	
	public void validate(Object target, Errors errors) {
		Location location = (Location) target;
		
		if(this.lRepo.existsByName(location.getName())) {
			errors.rejectValue("locationName","Duplicate Location Name","This Location Already Exists");
		}
	}
	
}
