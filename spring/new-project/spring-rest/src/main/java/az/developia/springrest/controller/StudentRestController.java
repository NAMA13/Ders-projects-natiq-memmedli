package az.developia.springrest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springrest.Model.Student;

@RestController
public class StudentRestController {
	
	@GetMapping()
	public Student giveMeStudent () {
		return new Student(1, "Natiq", 14);
	}
	
	@GetMapping(path = "/list")
	public List<Student> giveMeStudents () {
		return List.of(new Student(1, "Natiq", 14), new Student(1, "Natiq", 14));
	}
}
