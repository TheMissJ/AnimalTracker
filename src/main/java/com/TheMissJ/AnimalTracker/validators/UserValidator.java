package com.TheMissJ.AnimalTracker.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.TheMissJ.AnimalTracker.models.User;
import com.TheMissJ.AnimalTracker.repositories.UserRepository;



@Component
public class UserValidator {

	@Autowired
	private UserRepository uRepo;
	
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		
				//validate that password and confirmPassword are identical
		if(!user.getPassword().equals(user.getConfirmPassword())) {
				errors.rejectValue("password",  "Password Error", "Passwords Do Not Match");
		}
		
				//validate that the email address is not already in the database
		if(this.uRepo.existsByEmail(user.getEmail())) {
				errors.rejectValue("email",  "Duplicate Email", "This Email Is Already Registered");
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
