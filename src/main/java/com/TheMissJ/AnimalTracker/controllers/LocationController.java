package com.TheMissJ.AnimalTracker.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.TheMissJ.AnimalTracker.models.Location;
import com.TheMissJ.AnimalTracker.services.GiraffeService;
import com.TheMissJ.AnimalTracker.services.LocationService;
import com.TheMissJ.AnimalTracker.validators.LocationValidator;

@Controller
@RequestMapping("/location")
public class LocationController {

	@Autowired
	private LocationService lService;
	
	@Autowired
	private LocationValidator lValidator;
	
	@Autowired
	private GiraffeService gService;
	
	
						//Display Location Details
	
	@GetMapping("/{id}")
	public String displayLocation(@PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("location", this.lService.getById(id));
		viewModel.addAttribute("location", this.gService.getGiraffes());
		return "/location/showlocation.jsp";
		
	}

					//Add A Location Page
	
	@GetMapping("/new")
	private String newLocation(@ModelAttribute("location") Location location, Model viewModel) {
		viewModel.addAttribute("locations", this.lService.getLocations());
		return "/location/newlocation.jsp";
	}
	
	@PostMapping("/new")
	private String createLocation(@Valid @ModelAttribute("location") Location location, Model viewModel, BindingResult result) {
		lValidator.validate(location, result);
		if(result.hasErrors()) {
			return"/location/newlocation.jsp";
		}
		this.lService.create(location);
		Long locationId = location.getId();
		return "redirect:/location" + locationId;
	}
						
	
	
	
	
	
	
	
}
