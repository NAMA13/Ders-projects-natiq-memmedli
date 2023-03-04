package com.developia.CourseM.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
		model.addAttribute("header", "New Book");
		return "new-book";
	}

	@PostMapping(path = "/books/new-book-process")
	public String saveBook(@Valid @ModelAttribute(name = "book") Book book, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "new-book";
		}
		book.setImage("Book.jpg");		
		book.setUsername(getUsername());
		repository.save(book);
		List<Book> books = repository.findAll();
		model.addAttribute("books", books);
		return "redirect:/books/findAll";
	}

	@GetMapping(path = "/books/delete/{id}")
	public String deleteBook(@PathVariable(name = "id") Integer id) {
		boolean bookExists = repository.findById(id).isPresent();
		if (bookExists) {
			repository.deleteById(id);
		} else {

		}
		List<Book> books = repository.findAll();
		return "redirect:/books/findAll";
	}

	@GetMapping(path = "/books/edit/{id}")
	public String editBook(@PathVariable(name = "id") Integer id, Model model) {
		Optional<Book> bookOptional = repository.findById(id);
		boolean bookExists = bookOptional.isPresent();
		Book book = new Book();
		if (bookExists) {
			book = bookOptional.get();
		} else {

		}
		model.addAttribute("book", book);
		model.addAttribute("header", "Book Edit");
		return "new-book";
	}
}
