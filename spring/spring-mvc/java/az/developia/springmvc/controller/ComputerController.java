package az.developia.springmvc.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import az.developia.springmvc.model.Computer;
import az.developia.springmvc.service.ComputerService;

@Controller
@RequestMapping(path = "/computers")
public class ComputerController {

	@Autowired
	private ComputerService service;

	@GetMapping
	@PreAuthorize(value = "hasAuthority('computer:get:all')")
	public String showPage(Model model) {
		model.addAttribute("computers", service.findAll());

		return "computers";
	}

	@GetMapping(path = "computer/search")
	@PreAuthorize(value = "hasAuthority('computer:search')")
	public String showPageSearch(@RequestParam(name = "query", required = false, defaultValue = "") String ss, Model model) {
		model.addAttribute("computers", service.filter(ss));
		model.addAttribute("sorgu", ss);

		return "computers";
	}

	@GetMapping(path = "/open-save-page")
	@PreAuthorize(value = "hasAuthority('computer:add')")
	public String showSavePage(Model model) {
		Computer s = new Computer();

		model.addAttribute("computer", s);
		return "save-computer";
	}

	@PostMapping(path = "/save")
	@PreAuthorize(value = "hasAuthority('student:save')")
	public String save(@Valid @ModelAttribute(name = "computer") Computer s, BindingResult br) {
		if(br.hasErrors()) {
			return "save-computer";
		}
		service.save(s);
		return "redirect:/computers";
	}

	@GetMapping(path = "/delete/{id}")
	@PreAuthorize(value = "hasAuthority('computer:delete')")
	public String delete(@PathVariable Integer id) {
		service.delete(id);
		return "redirect:/computers";
	}

	@GetMapping(path = "/edit/{id}")
	@PreAuthorize(value = "hasAuthority('computer:edit')")
	public String edit(@PathVariable Integer id, Model model) {
		Computer c = service.findById(id);
		model.addAttribute("computer", c);
		return "save-computer";
	}

}
