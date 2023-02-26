package com.developia.CourseM.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.developia.CourseM.Model.Book;
import com.developia.CourseM.Repository.BookRepository;

@Controller
public class CustomerController {
	@GetMapping(path = "/customers")
	public String showCustomerPage(Model model) {
		
		return "customer";
	}
}
