package az.developia.springmvc;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/books")
public class BooksController {

	@Autowired
	private BookService service;

	@GetMapping
	public String showPage(Model model) {
		model.addAttribute("Books", service.books);

		return "books";
	}

	@GetMapping(path = "/search")

	public String showPageSearch(@RequestParam(name = "sorgu", required = false, defaultValue = "") String ss,
			Model model) {
		model.addAttribute("telebeler", service.filter(ss));
		model.addAttribute("sorgu", ss);
		return "books";
	}

	@GetMapping(path = "/open-save-books-page")
	public String showSavePage(Model model) {
		Student s = new Student();

		model.addAttribute("student", s);
		return "save-student";
	}

	@PostMapping(path = "/save")
	public String save(@ModelAttribute(name = "book") Student s) {
		service.books.add(s);
		return "redirect:/books";
	}

}
