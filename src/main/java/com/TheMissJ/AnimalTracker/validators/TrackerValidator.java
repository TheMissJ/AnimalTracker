package com.TheMissJ.AnimalTracker.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.TheMissJ.AnimalTracker.models.Tracker;
import com.TheMissJ.AnimalTracker.repositories.TrackerRepository;

@Component
public class TrackerValidator {

	@Autowired
	private TrackerRepository tRepo;
	
	public void validate (Object target, Errors errors) {
		Tracker tracker = (Tracker) target;
		
		if(this.tRepo.existsByName(tracker.getName())) {
			errors.rejectValue("Tracker Name", "Duplicate Tracker Name", "This Tracker Name Already Exists");
		}
	}
}
