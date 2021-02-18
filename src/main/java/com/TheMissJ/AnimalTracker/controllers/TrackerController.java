package com.TheMissJ.AnimalTracker.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.TheMissJ.AnimalTracker.models.Tracker;
import com.TheMissJ.AnimalTracker.services.GiraffeService;
import com.TheMissJ.AnimalTracker.services.TrackerService;
import com.TheMissJ.AnimalTracker.validators.TrackerValidator;

@Controller
@RequestMapping("/tracker")
public class TrackerController {

	@Autowired
	private TrackerService tService;
	
	@Autowired
	private GiraffeService gService;
	
	@Autowired
	private TrackerValidator tValidator;
	
	
						//Add a New Tracker
	
	@GetMapping("/new")
	private String newTracker(@ModelAttribute("tracker") Tracker tracker, Model viewModel) {
		viewModel.addAttribute("tracker", this.tService.getTrackers());
		return "/tracker/newtracker.jsp";
	}

	@PostMapping("/new")
	private String createTracker(@Valid @ModelAttribute("tracker") Tracker tracker, Model viewModel, BindingResult result, HttpSession session) {
		tValidator.validate(tracker, result);
		if(result.hasErrors()) {
			return "/tracker/newtracker.jsp";
		}
		this.tService.create(tracker);
		return "redirect:/giraffe";
	}
	
	
	
	
}
