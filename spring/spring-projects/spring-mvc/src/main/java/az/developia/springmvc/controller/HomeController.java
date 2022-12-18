package az.developia.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping
	public String showHome() {
		return "home";
	}

	@GetMapping(path = "/error")

	public String showError(Model m) {

		m.addAttribute("message", "Link tapılmadı!!!");
		return "my-message";

	}

}
