package az.developia.springmvc.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@GetMapping
	public String showHome() {
		return "home";
	}
	
	@GetMapping(path="/my-login")
	public String showMyLogin() {
		return "my-custom-login";
	}
	
	@GetMapping(path="/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/my-login";
	}
	
	@GetMapping(path = "/error")
	public String showError(    Model m) {
 
			m.addAttribute("message", "link yoxdu");
			return "my-message";
		 
	}
//	@GetMapping(path="/create-account")
//	public String createAccount( ) {
//		 
//		return "create-account";
//	}
	
}
