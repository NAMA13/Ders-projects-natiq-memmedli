package az.developia.springrest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springrest.Model.EBookModel;

@RestController
public class StudentRestController {
	
	@GetMapping()
	public EBookModel giveMeStudent () {
		return new EBookModel(0, "3-cu addim", 80);
	}
	
	@GetMapping(path = "/list")
	public List<EBookModel> giveMeStudents () {
		return List.of(new EBookModel(1, "2-cu addim", 80), new EBookModel(2, "1-cu addim", 80));
	}
}
