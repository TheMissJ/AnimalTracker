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
import com.TheMissJ.AnimalTracker.models.Note;
import com.TheMissJ.AnimalTracker.models.ConGroup;
import com.TheMissJ.AnimalTracker.models.User;
import com.TheMissJ.AnimalTracker.services.GiraffeService;
import com.TheMissJ.AnimalTracker.services.ConGroupService;
import com.TheMissJ.AnimalTracker.services.LocationService;
import com.TheMissJ.AnimalTracker.services.NoteService;
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
		User user = this.uService.getSingleUser((Long)session.getAttribute("user_id"));
		Long userId = (Long)session.getAttribute("user_id");
		viewModel.addAttribute("user", this.uService.getSingleUser(userId));
		return "dashboard.jsp";
	}
	
						//Add A Giraffe Page
	
	@GetMapping("/new")
	private String newGiraffe(@ModelAttribute("giraffe") Giraffe giraffe, Model viewModel) {
		viewModel.addAttribute("locations", this.lService.getLocations());
		viewModel.addAttribute("trackers", this.tService.getTrackers());
		viewModel.addAttribute("giraffes", this.gService.getGiraffes());
		return "new.jsp";
	}
	
	@PostMapping("/new")
	private String createGiraffe(@Valid @ModelAttribute("giraffe") Giraffe giraffe, Model viewModel, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "new.jsp";
		}
		Long userId = (Long)session.getAttribute("user_id");
		User userCreatedGiraffe = this.uService.getSingleUser(userId);
		giraffe.setLocation(viewModel.getAttribute("location"));
		giraffe.setGiraffeCreator(userCreatedGiraffe);
		giraffe.setMyTracker(viewModel.getAttribute("tracker"));
		giraffe.setMother(viewModel.getAttribute("mother"));
		giraffe.setFather(viewModel.getAttribute("father"));
		this.gService.create(giraffe);
		return "redirect:/giraffe";
	}
	
					//Add Note For Giraffe
	@GetMapping("/edit/{giraffe.id}/note/add")
	public String addNote(@ModelAttribute("note") Note note, BindingResult result, @PathVariable("giraffe.id") Long id, Model viewModel, HttpSession session) {
	viewModel.addAttribute("note", this.nService.getNotes());
	return "/note/newnote.jsp";
	
	}

	@PostMapping("/edit/{giraffe.id}/note/add")
	public String createNote(@ModelAttribute("note") Note note, BindingResult result, @PathVariable("giraffe.id") Long id, Model viewModel, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		Giraffe giraffeId = this.gService.getById(id);
		User userCreatedNote = this.uService.getSingleUser(userId);
		note.setNoteCreator(userCreatedNote);
		note.setGiraffe(giraffeId);
		return "redirect:/giraffe/" + giraffeId;
	}
		
	
						//Display Giraffe Details Page
	
	@GetMapping("/{id}")
	public String displayGiraffe(@PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("giraffe", this.gService.getById(id));
		return "show.jsp";
		
	}
	
					//Edit a Giraffe Page
	
	@GetMapping("/edit/{id}")
	public String editGiraffe(@PathVariable("id") Long id, @ModelAttribute("giraffe") Giraffe giraffe, Model viewModel) {
		viewModel.addAttribute("giraffe", this.gService.getById(id));
		viewModel.addAttribute("users", this.uService.getAllUsers());
		viewModel.addAttribute("locations", this.lService.getLocations());
		viewModel.addAttribute("trackers", this.tService.getTrackers());
		viewModel.addAttribute("giraffes", this.gService.getGiraffes());
		return "edit.jsp";
		
	}
	
	@PostMapping("/edit/{id}")
	public String updateGiraffe(@Valid @ModelAttribute("giraffe") Giraffe giraffe, BindingResult result, @PathVariable("id") Long id, Model viewModel, HttpSession session) {
		Long giraffeId = giraffe.getId();
		if(result.hasErrors()) {
			viewModel.addAttribute("giraffe", this.gService.getById(giraffeId));
			viewModel.addAttribute("users", this.uService.getAllUsers());
			viewModel.addAttribute("locations", this.lService.getLocations());
			viewModel.addAttribute("trackers", this.tService.getTrackers());
			viewModel.addAttribute("giraffes", this.gService.getGiraffes());
			System.out.println("are we here?");
			return "edit.jsp";
		}
		Long userId = (Long)session.getAttribute("user_id");
		User userUpdatedGiraffe = this.uService.getSingleUser(userId);
		giraffe.setUpdatedBy(userUpdatedGiraffe);
		giraffe.setBirth_year(viewModel.getAttribute("birth_year"));
		giraffe.setGender(viewModel.getAttribute("gender"));
		giraffe.setSpecies(viewModel.getAttribute("species"));
		giraffe.setHeight(viewModel.getAttribute("height"));
		giraffe.setWeight(viewModel.getAttribute("weight"));
		giraffe.setLocation(viewModel.getAttribute("location"));
		giraffe.setMyTracker(viewModel.getAttribute("myTracker"));
		giraffe.setMother(viewModel.getAttribute("mother"));
		giraffe.setFather(viewModel.getAttribute("father"));
		giraffe.setDeceased(viewModel.getAttribute("deceased"));
		giraffe.setDeath_year(viewModel.getAttribute("death_year"));
		giraffe.setDeathCause(viewModel.getAttribute("deathCause"));
		this.gService.update(giraffe);
		return "redirect:/giraffe";
		
	}
	
	

				
	
	
	
	
}
