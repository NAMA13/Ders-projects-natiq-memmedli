package az.developia.computershopping.controller;


import java.util.List;

import az.developia.computershopping.model.Computer;
import az.developia.computershopping.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import az.developia.computershopping.model.CategoryModel;
import az.developia.computershopping.repository.CategoryRepository;

@RestController
@RequestMapping(path = "/categories")
@CrossOrigin(origins = "*")
public class CategoryRestController {
	
	@Autowired
	private CategoryRepository categoryRepo;

	@Autowired
	private ComputerRepository computerRepository;
	
	@GetMapping
	public List<CategoryModel> loadCategories() {
		return categoryRepo.findAll();
	}

	@GetMapping("/selected")
	public List<Computer> loadComputersOnCategorySelected(@RequestParam String name) {
		return computerRepository.findAllByCategory(name);
	}

	@DeleteMapping(path="/{id}")
	public void deleteById(@PathVariable Integer id) {
		categoryRepo.deleteById(id);
	}

}