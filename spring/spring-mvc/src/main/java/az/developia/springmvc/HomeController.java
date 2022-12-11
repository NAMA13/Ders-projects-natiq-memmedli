package az.developia.springmvc;

import java.util.ArrayList;

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
	
	
	@GetMapping(path = "/error")
	public String showError(    Model m) {
 
			m.addAttribute("message", "link yoxdu");
			return "my-message";
		 
	}
	
}
