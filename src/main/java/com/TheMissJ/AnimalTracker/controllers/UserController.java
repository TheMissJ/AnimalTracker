package com.TheMissJ.AnimalTracker.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.TheMissJ.AnimalTracker.models.User;
import com.TheMissJ.AnimalTracker.services.ConGroupService;
import com.TheMissJ.AnimalTracker.services.PictureService;
import com.TheMissJ.AnimalTracker.services.UserService;
import com.TheMissJ.AnimalTracker.validators.UserValidator;



@Controller
public class UserController {

	@Autowired
	private UserService uService;
	
	@Autowired
	private UserValidator uValidator;
	
	@Autowired
	private ConGroupService cService;
	
	@Autowired
	private PictureService pService;
	
	private static String UPLOAD_FOLDER="src/main/resources/static/images/";
	
																				//load the home page
	@GetMapping("/")
	public String index(@ModelAttribute("user") User user) {
		return "index.jsp";
	}
	
																				//register a new user after data input
	@PostMapping("/user/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		uValidator.validate(user, result);
		if(result.hasErrors()) {
			return "index.jsp";
		}
		User newUser = this.uService.registerUser(user);
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/giraffe";
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
		return "redirect:/giraffe";
		
	}
																				//process the user logout
	@GetMapping("/logout")												
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
		
	}
	
	
																			//view user page
	@GetMapping("/user/{id}")
	public String displayUser(@PathVariable("id") Long id, Model viewModel, HttpSession session) {
		viewModel.addAttribute("user", this.uService.getSingleUser(id));
		User user = this.uService.getSingleUser((Long)session.getAttribute("user_id"));
		return "/user/showuser.jsp";
	}
	
																		//edit user page
	@GetMapping("/user/edit/{id}")
	public String editUser(@PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("user", this.uService.getSingleUser(id));
		viewModel.addAttribute("congroups", this.cService.getGroups());
		viewModel.addAttribute("employer", this.uService.getSingleUser(id).getEmployer());
		viewModel.addAttribute("pic", uService.getSingleUser(id).getProfilePic());
		return "/user/edituser.jsp";
	}
	
	@PostMapping("/user/edit/{id}")
	public String updateUser(@Valid @ModelAttribute("user") User user, BindingResult result, @PathVariable("id") Long id, Model viewModel, HttpSession session) {
		Long userId = user.getId();
		if(result.hasErrors()) {
			viewModel.addAttribute("user", uService.getSingleUser(userId));
			return "/user/edituser.jsp";
		}
		this.uService.update(user);
		return "redirect:/user/" + userId;

	}
	
																		//upload picture
	
	@GetMapping("/user/upload/{id}")
	public String setPicture(@PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("user", this.uService.getSingleUser(id));
		return "/user/edituserpic.jsp";
	}
	
	@PostMapping("/user/upload/{id}")
	public String upload(@RequestParam("pic") MultipartFile file, HttpSession session, RedirectAttributes redirectAttr) {
		Long userId = (Long)session.getAttribute("user_id");
		User user = uService.getSingleUser(userId);

		if(file.isEmpty()) {
			redirectAttr.addFlashAttribute("message", "Upload field cannot be empty");
			return "redirect:/user/upload/{user.id}";
		}

		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);
			String url = "/images/"+ file.getOriginalFilename();
			this.pService.uploadPic(user, url);
			

		}catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/giraffe";
	}
	
	
	
}
