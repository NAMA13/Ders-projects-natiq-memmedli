package az.developia.bookshopping.controller;

import java.util.List;

import az.developia.bookshopping.model.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import az.developia.bookshopping.BookDAO;
import az.developia.bookshopping.model.Book;

@RestController
@RequestMapping(path="/rest/books")
public class BookRestController {

	@Autowired
	private BookDAO bookDAO;
	
	@GetMapping
	public List<Book> findAll() {
		return bookDAO.findAll();
	}
	
	@GetMapping(path="/{id}")
	public Book findById(@PathVariable(name="id") Integer id) {
		return bookDAO.findById(id).get();
	}


	@PostMapping(path="/search")
	public List<Book> findAllSearch (@RequestBody Search search){
		return bookDAO.findAllSearchAllFields(search.getSearch());

	}
}
