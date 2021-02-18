package com.TheMissJ.AnimalTracker.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.TheMissJ.AnimalTracker.models.Species;
import com.TheMissJ.AnimalTracker.repositories.SpeciesRepository;

@Component
public class SpeciesValidator {

	@Autowired
	private SpeciesRepository sRepo;
	
	public void validate(Object target, Errors errors) {
		Species species = (Species) target;
		
		if(this.sRepo.existsByName(species.getName())) {
			errors.rejectValue("Species Name","Duplicate Species Name","This Species Already Exists");
		}
	}
	
}
