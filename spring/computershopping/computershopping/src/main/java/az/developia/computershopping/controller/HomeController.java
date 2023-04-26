package az.developia.computershopping.controller;


import az.developia.computershopping.dao.ComputerDAO;
import az.developia.computershopping.model.Computer;
import az.developia.computershopping.model.Order;
import az.developia.computershopping.repository.CategoryRepository;
import az.developia.computershopping.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import az.developia.computershopping.config.MySession;
import springfox.documentation.annotations.ApiIgnore;

@Controller
public class HomeController {

	@Autowired
	private ComputerDAO computerDAO;

	@Autowired
	private ComputerRepository computerRepository;

	@Autowired
	private MySession mySession;

	private BasketController basketController;

	@Autowired
	private CategoryRepository categoryRepository;

	
	@GetMapping
	public String showHomePage(Model model) {
		System.out.println(mySession.getBasketComputers());
		model.addAttribute("username",mySession.getUsername());
		return "index";
	}


	@GetMapping(path = "/show-setting")
	public String showSettingsPage() {
		return "settings";
	}

}
