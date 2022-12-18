package az.developia.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import az.developia.springmvc.service.StudentService;

@Controller
@RequestMapping(path = "/students")
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping
	public String showPage(Model model) {
		model.addAttribute("students", service.findAll());

		return "students";
	}

	@GetMapping(path = "/search")

	public String showPageSearch(@RequestParam(name = "query", required = false, defaultValue = "") String query,
			Model model) {
		model.addAttribute("students", service.filter(query));
		model.addAttribute("query", query);
		return "students";
	}

	@GetMapping(path = "/open-save-page")
	public String showSavePage(Model model) {
		Student s = new Student();

		model.addAttribute("student", s);
		model.addAttribute("header", "Yeni tələbə qeydiyyatı");
		
		return "save-student";
	}

	@PostMapping(path = "/save")
	public String save(@ModelAttribute(name = "student") Student s) {
		service.save(s);
		return "redirect:/students";
	}

	@GetMapping(path = "/delete/{id}")
	public String delete(@PathVariable Integer id) {
		service.delete(id);
		return "redirect:/students";
	}

	@GetMapping(path = "/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		 
		Student s = service.findById(id);
		model.addAttribute("student", s);
		model.addAttribute("header", "Tələbə redaktəsi");
		return "save-student";
	}

}
