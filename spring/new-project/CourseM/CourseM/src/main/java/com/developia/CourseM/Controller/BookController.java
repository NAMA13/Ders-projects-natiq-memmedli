package com.developia.CourseM.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.developia.CourseM.Model.Book;
import com.developia.CourseM.Repository.BookRepository;

@Controller
public class BookController {

	public static String getUsername() {
		String currentUserName = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			currentUserName = authentication.getName();
		}
		return currentUserName;
	}

	@Autowired
	private BookRepository repository;

	@GetMapping(path = "/books/findAll")
	public String showHomePage(Model model) {
		List<Book> books = repository.findAll();
		model.addAttribute("books", books);
		return "books";
	}

	@GetMapping(path = "/books/new")
	public String openNewBookPage(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		return "new-book";
	}

	@PostMapping(path = "/books/new-book-process")
	public String saveBook(@ModelAttribute(name = "book") Book book, Model model) {
		book.setImage("Book.jpg");

		book.setUsername(getUsername());
		repository.save(book);
		List<Book> books = repository.findAll();
		model.addAttribute("books", books);
		return "redirect:/books/findAll";
	}
}
