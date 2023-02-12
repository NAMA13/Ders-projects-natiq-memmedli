package az.developia.springrest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springrest.Model.Student;

@RestController
public class StudentRestController {
	
	@GetMapping()
	public Student giveMeStudent () {
		return new Student(1, "Natiq", 14);
	}
}
