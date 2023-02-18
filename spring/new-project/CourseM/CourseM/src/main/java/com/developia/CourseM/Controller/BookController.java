package com.developia.CourseM.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.developia.CourseM.Model.Book;
import com.developia.CourseM.Repository.BookRepository;

@Controller
public class BookController {
	@Autowired 
	private BookRepository repository;
	
	@GetMapping(path="/books/findAll")
	public String showHomePage(Model model) {
		List<Book> books = repository.findAll();
		model.addAttribute("books", books);
		return "books";
	}
	
	@GetMapping(path="/books/new")
	public String openNewBookPage(Model model) {

		return "new-book";
	}
}
