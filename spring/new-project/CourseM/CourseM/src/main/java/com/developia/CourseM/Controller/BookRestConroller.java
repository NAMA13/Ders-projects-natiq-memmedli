package com.developia.CourseM.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.developia.CourseM.Model.Book;
import com.developia.CourseM.Repository.BookRepository;

@RestController
@RequestMapping(path="/rest/books")
public class BookRestConroller {
	
	@Autowired 
	private BookRepository repository;
	
	@GetMapping
	public List<Book> findAll(){
		return repository.findAll();
	}
	@GetMapping(path="/{id}")
	public Book findById(@PathVariable(name="id") Integer id){
		return repository.findById(id).get();
	}
}
