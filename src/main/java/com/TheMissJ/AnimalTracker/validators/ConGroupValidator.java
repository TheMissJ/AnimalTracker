package com.TheMissJ.AnimalTracker.validators;

import org.apache.catalina.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.TheMissJ.AnimalTracker.models.ConGroup;
import com.TheMissJ.AnimalTracker.repositories.ConGroupRepository;

@Component
public class ConGroupValidator {

	@Autowired
	private ConGroupRepository cRepo;
	
	public void validate(Object target, Errors errors) {
		ConGroup group = (ConGroup) target;
		
		if(this.cRepo.existsByName(group.getName())) {
			errors.rejectValue("name", "Duplicate ConGroup Name", "This ConGroup Already Exists");
		}
		
	}
	
	
	
}
