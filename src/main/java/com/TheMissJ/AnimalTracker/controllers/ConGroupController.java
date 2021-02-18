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

import com.TheMissJ.AnimalTracker.models.ConGroup;
import com.TheMissJ.AnimalTracker.models.User;
import com.TheMissJ.AnimalTracker.services.GiraffeService;
import com.TheMissJ.AnimalTracker.services.ConGroupService;
import com.TheMissJ.AnimalTracker.services.UserService;
import com.TheMissJ.AnimalTracker.validators.ConGroupValidator;

@Controller
@RequestMapping("/congroup")
public class ConGroupController {


	@Autowired 
	private GiraffeService gService;
	
	@Autowired
	private ConGroupService cService;
	
	@Autowired
	private UserService uService;
	
	@Autowired
	private ConGroupValidator cValidator;
	

					//Display ConGroup Details Page

	@GetMapping("/{id}")
	public String displayConGroup(@PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("congroup", this.cService.getById(id));
		return "/congroup/showgroup.jsp";

	}

					//Add A ConGroup Page

	@GetMapping("/new")
	private String newConGroup(@ModelAttribute("congroup") ConGroup conGroup, Model viewModel) {
		return "/congroup/newgroup.jsp";
	}

	@PostMapping("/new")
	private String createGroup(@Valid @ModelAttribute("congroup") ConGroup conGroup, Model viewModel, BindingResult result, HttpSession session) {
		cValidator.validate(conGroup, result);
		if(result.hasErrors()) {
			return "/congroup/newgroup.jsp";
		}
		this.cService.create(conGroup);
		return "redirect:/giraffe";
	}

}
