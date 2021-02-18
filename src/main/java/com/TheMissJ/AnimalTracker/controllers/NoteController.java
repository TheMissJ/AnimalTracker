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
import com.TheMissJ.AnimalTracker.models.User;
import com.TheMissJ.AnimalTracker.services.GiraffeService;
import com.TheMissJ.AnimalTracker.services.NoteService;
import com.TheMissJ.AnimalTracker.services.UserService;

@Controller
@RequestMapping("/notes")
public class NoteController {

	@Autowired
	private NoteService nService;
	
	@Autowired
	private GiraffeService gService;
	
	@Autowired
	private UserService uService;
	
	
					//Display Notes Details Page

	@GetMapping("/{id}")
	public String displayNote(@PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("note", this.nService.getById(id));
		return "/note/shownote.jsp";

	}

					//Add A Note Page

	@GetMapping("/new")
	private String newNote(@ModelAttribute("note") Note note, Model viewModel) {
		viewModel.addAttribute("notes", this.nService.getNotes());
		return "/note/newnote.jsp";
	}

	@PostMapping("/new")
	private String createnote(@ModelAttribute("note") Note note, Model viewModel, BindingResult result, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		Long giraffeId = (Long)session.getAttribute("giraffe_id");
		User userCreatedNote = this.uService.getSingleUser(userId);
		Giraffe noteForGiraffe = this.gService.getById(giraffeId);
		note.setNoteCreator(userCreatedNote);
		note.setGiraffe(noteForGiraffe);
		this.nService.create(note);
		return "redirect:/giraffe";
	}

}
