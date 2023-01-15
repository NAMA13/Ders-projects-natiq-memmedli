package az.developia.springmvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import az.developia.springmvc.model.UserModel;
import az.developia.springmvc.service.UserService;

//import az.developia.springmvc.model.Student;
//import az.developia.springmvc.model.UserModel;
//import az.developia.springmvc.service.UserService;

@Controller
@RequestMapping(path = "/users")
public class UserController {
	
	
	@Autowired
	private UserService service;
	
	
	@GetMapping(path = "/create-account")
	//@PreAuthorize(value = "hasAuthority('student:add')")
	public String showSavePage(Model model) {
		UserModel user = new UserModel();

		model.addAttribute("user", user);
		 
		return "create-account";
	}

	@PostMapping(path = "/save")
	//@PreAuthorize(value = "hasAuthority('student:save')")	
	public String save(@Valid @ModelAttribute(name = "user") UserModel user,BindingResult br) {		 
		if(br.hasErrors()) {
			return "create-account";
		} 
		service.save(user);
		return "redirect:/my-login";
	}

}