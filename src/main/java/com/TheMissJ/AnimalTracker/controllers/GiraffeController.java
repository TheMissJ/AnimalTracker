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

import com.TheMissJ.AnimalTracker.models.Giraffe;
import com.TheMissJ.AnimalTracker.models.ConGroup;
import com.TheMissJ.AnimalTracker.models.User;
import com.TheMissJ.AnimalTracker.services.GiraffeService;
import com.TheMissJ.AnimalTracker.services.ConGroupService;
import com.TheMissJ.AnimalTracker.services.LocationService;
import com.TheMissJ.AnimalTracker.services.NoteService;
import com.TheMissJ.AnimalTracker.services.SpeciesService;
import com.TheMissJ.AnimalTracker.services.SubSpeciesService;
import com.TheMissJ.AnimalTracker.services.TrackerService;
import com.TheMissJ.AnimalTracker.services.UserService;

@Controller
@RequestMapping("/giraffe")
public class GiraffeController {

	@Autowired 
	private GiraffeService gService;
	
	@Autowired
	private ConGroupService cService;
	
	@Autowired 
	private LocationService lService;
	
	@Autowired
	private NoteService nService;
	
	@Autowired
	private SpeciesService sService;
	
	@Autowired
	private SubSpeciesService subService;
	
	@Autowired
	private TrackerService tService;
	
	@Autowired
	private UserService uService;
	
							//Dashboard Page Load
	
	@GetMapping("")
	private String landing(Model viewModel, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		viewModel.addAttribute("giraffes", this.gService.getGiraffes());
//		Giraffe thisGiraffe = this.gService.getById(giraffeId);
//		User updatedByUser = thisGiraffe.getUpdatedBy();
//		ConGroup groupEmployed = updatedByUser.getEmployer();

		
		
		User user = this.uService.getSingleUser((Long)session.getAttribute("user_id"));
		Long userId = (Long)session.getAttribute("user_id");
		viewModel.addAttribute("user", this.uService.getSingleUser(userId));

		return "dashboard.jsp";
	}
	
						//Add A Giraffe Page
	
	@GetMapping("/new")
	private String newGiraffe(@ModelAttribute("giraffe") Giraffe giraffe, Model viewModel) {
		viewModel.addAttribute("giraffes", this.gService.getGiraffes());
		return "new.jsp";
	}
	
	@PostMapping("/new")
	private String createGiraffe(@ModelAttribute("giraffe") Giraffe giraffe, Model viewModel, BindingResult result, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		User userCreatedGiraffe = this.uService.getSingleUser(userId);
		giraffe.setGiraffeCreator(userCreatedGiraffe);
		this.gService.create(giraffe);
		return "redirect:/giraffe";
	}	
	
	
						//Display Giraffe Details Page
	
	@GetMapping("/{id}")
	public String displayGiraffe(@PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("giraffe", this.gService.getById(id));
		return "show.jsp";
		
	}
	
					//Edit a Giraffe Page
	
	@GetMapping("/edit/{id}")
	public String editGiraffe(@PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("giraffe", this.gService.getById(id));
		viewModel.addAttribute("users", this.uService.getAllUsers());
		return "edit.jsp";
		
	}
	
	@PostMapping(value="/edit/{id}")
	public String updateGiraffe(@Valid @ModelAttribute("giraffe") Giraffe giraffe, BindingResult result, @PathVariable("id") Long id, Model viewModel, HttpSession session) {
		Long giraffeId = giraffe.getId();
		if(result.hasErrors()) {
			viewModel.addAttribute("giraffe", gService.getById(giraffeId));
			return "edit.jsp";
		}
		this.gService.update(giraffe);
		return "redirect:/giraffe/" + giraffeId;
		
	}
	

				
	
	
	
	
}
