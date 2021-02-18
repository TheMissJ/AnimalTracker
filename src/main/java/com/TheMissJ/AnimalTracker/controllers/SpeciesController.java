package com.TheMissJ.AnimalTracker.controllers;

import javax.servlet.http.HttpSession;
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

import com.TheMissJ.AnimalTracker.models.Species;
import com.TheMissJ.AnimalTracker.models.SubSpecies;
import com.TheMissJ.AnimalTracker.services.GiraffeService;
import com.TheMissJ.AnimalTracker.services.SpeciesService;
import com.TheMissJ.AnimalTracker.services.SubSpeciesService;
import com.TheMissJ.AnimalTracker.validators.SpeciesValidator;
import com.TheMissJ.AnimalTracker.validators.SubSpeciesValidator;

@Controller
@RequestMapping("/species")
public class SpeciesController {

	@Autowired
	private SpeciesService sService;
	
	@Autowired
	private SubSpeciesService subService;
	
	@Autowired
	private GiraffeService gService;
	
	@Autowired
	private SpeciesValidator sValidator;
	
	@Autowired
	private SubSpeciesValidator subValidator;
	
	
						//Display Species Details Page
	
	@GetMapping("/{id}")
	public String displaySpecies(@PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("species", this.sService.getById(id));
		viewModel.addAttribute("subspecies", this.sService.getSubSpecies(id));
		return "/species/showspecies.jsp";
	}
	
	
						//Add a New Species and/or Sub-Species
	
	@GetMapping("/new")
	private String newSpecies(@ModelAttribute("species") Species species, Model viewModel) {
		viewModel.addAttribute("species", this.sService.getSpeciess());
		return "/species/newspecies.jsp";
	}
	
	@PostMapping("/new")
	private String createSpecies(@Valid @ModelAttribute("species") Species species, Model viewModel, BindingResult result) {
		sValidator.validate(species, result);
		if(result.hasErrors()) {
			return "/species/newspecies.jsp";
		}
		this.sService.create(species);
		return "redirect:/species/{id}";
	}
		
	
	
		@GetMapping("/add_subspecies")
		private String newSubSpecies(@ModelAttribute("subspecies") SubSpecies subspecies, Model viewModel) {
			viewModel.addAttribute("species", this.sService.getSpeciess());
			return "/species/new_subspecies.jsp";
		}
		
		@PostMapping("/add_subspecies")
		private String createSubSpecies(@Valid @ModelAttribute("subspecies") SubSpecies subspecies, Model viewModel, BindingResult result, HttpSession session) {
			subValidator.validate(subspecies, result);
			if(result.hasErrors()) {
				return "/species/new_subspecies.jsp";
			}
			Long speciesId = (Long)session.getAttribute("species_id");
			this.subService.create(subspecies);
			return "redirect:/species/{id}";
		
		
	}
	
	
	
	
	
	
	
}
