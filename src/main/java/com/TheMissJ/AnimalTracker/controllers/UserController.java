package com.TheMissJ.AnimalTracker.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.TheMissJ.AnimalTracker.models.User;
import com.TheMissJ.AnimalTracker.services.UserService;
import com.TheMissJ.AnimalTracker.validators.UserValidator;



@Controller
public class UserController {

	@Autowired
	private UserService uService;
	
	@Autowired
	private UserValidator uValidator;
	
																				//load the home/index page
	@GetMapping("/")
	public String index(@ModelAttribute("user") User user) {
		return "index.jsp";
	}
	
																				//register a new user after data input
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		uValidator.validate(user, result);
		if(result.hasErrors()) {
			return "index.jsp";
		}
		User newUser = this.uService.registerUser(user);
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/ideas";
	}
																				//process the login with entered credentials
	@PostMapping("/login")
	public String login(@RequestParam("lemail") String email, @RequestParam("lpassword") String password, RedirectAttributes redirectAttrs, HttpSession session) {
		if(!this.uService.authenticateUser(email, password)) {
			redirectAttrs.addFlashAttribute("loginError", "Invalid Credentials");
			return "redirect:/";
		}
		User user = this.uService.getByEmail(email);
		session.setAttribute("user_id", user.getId());
		return "redirect:/ideas";
		
	}
																				//process the user logout
	@GetMapping("/logout")												
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
		
	}
	
	
	
	
	
	
	
}
