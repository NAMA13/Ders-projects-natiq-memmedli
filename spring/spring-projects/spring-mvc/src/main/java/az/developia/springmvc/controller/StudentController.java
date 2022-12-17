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

import az.developia.springmvc.model.Computer;
import az.developia.springmvc.service.StudentService;

@Controller
@RequestMapping(path = "/computers")
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping
	public String showPage(Model model) {
		model.addAttribute("computers", service.findAll());

		return "computers";
	}

	@GetMapping(path = "/computers")
	public String showPageSearch(@RequestParam(name = "sorgu", required = false, defaultValue = "") String ss,
			Model model) {
		model.addAttribute("computers", service.filter(ss));
		model.addAttribute("sorgu", ss);
		return "computers";
	}

	@GetMapping(path = "/open-save-page")
	public String showSavePage(Model model) {
		Computer s = new Computer(null, null, null, 0);

		model.addAttribute("computer", s);
		return "save-student";
	}

	@PostMapping(path = "/save")
	public String save(@ModelAttribute(name = "computer") Computer s) {
		service.save(s);
		return "redirect:/computers";
	}

	@GetMapping(path = "/delete/{id}")
	public String delete(@PathVariable Integer id) {
		service.delete(id);
		return "redirect:/computers";
	}

	@GetMapping(path = "/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Computer c = service.findComputer(id);
		model.addAttribute("computer", c);
		return "save-student";
	}

}
