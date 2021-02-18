package com.TheMissJ.AnimalTracker.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.TheMissJ.AnimalTracker.models.SubSpecies;
import com.TheMissJ.AnimalTracker.repositories.SubSpeciesRepository;

@Component
public class SubSpeciesValidator {

	@Autowired
	private SubSpeciesRepository subRepo;
	
	public void validate(Object target, Errors errors) {
		SubSpecies sub_species = (SubSpecies) target;
		
		if(this.subRepo.existsByName(sub_species.getName())) {
			errors.rejectValue("Sub-Species Name","Duplicate Sub-Species Name","This Sub-Species Already Exists");
		}
	}
	
}
