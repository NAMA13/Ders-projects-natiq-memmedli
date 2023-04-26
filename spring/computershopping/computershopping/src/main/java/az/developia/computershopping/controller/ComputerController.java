package az.developia.computershopping.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import az.developia.computershopping.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import az.developia.computershopping.config.MySession;
import az.developia.computershopping.file.StorageService;
import az.developia.computershopping.model.Computer;

@Controller
public class ComputerController {



	@Autowired
	private MySession mySession;

	@Autowired
	private StorageService storageService;

	@Autowired
	private ComputerRepository computerRepository;

	

	@GetMapping("/show-computer")
	public String showComputersPage(Model model) {
		System.out.println(computerRepository.findAll());
		System.out.println("asdasdasdasdasd");
		Computer computer = new Computer();
		model.addAttribute("computers", computer);
		return "computers";
	}

//
//
//	@PostMapping(path = "/computers/new-computer-process")
//	public String saveComputer(@Valid @ModelAttribute(name = "computer") Computer computer, BindingResult result,
//			@RequestParam(value = "imageFile", required = false) MultipartFile imageFile, Model model) {
//		if (result.hasErrors()) {
//			return "new-computer";
//		}
//		computer.setUsername(mySession.getUsername());
//		if (imageFile.isEmpty() && computer.getId() != null) {
//			computer.setImage(computerRepository.findById(computer.getId()).get().getImage());
//		}else {
//			computer.setImage(storageService.store(imageFile));
//		}
//		computerRepository.save(computer);
//		List<Computer> computers = computerRepository.findAll();
//		model.addAttribute("computers", computers);
//		return "redirect:/computers";
//	}
//
//	@GetMapping(path = "/computers/delete/{id}")
//	public String deleteComputer(@PathVariable(name = "id") Integer id, Model model) {
//		boolean computerExists = computerRepository.findById(id).isPresent();
//		if (computerExists) {
//			computerRepository.deleteById(id);
//		} else {
//		}
//
//		List<Computer> computers = computerRepository.findAll();
//		model.addAttribute("computers", computers);
//
//		return "redirect:/computers";
//	}
//
//	@GetMapping(path = "/computers/edit/{id}")
//	public String editComputer(@PathVariable(name = "id") Integer id, Model model) {
//		Optional<Computer> computerOptional = computerRepository.findById(id);
//		boolean computerExists = computerOptional.isPresent();
//		Computer computer = new Computer();
//		if (computerExists) {
//			computer = computerOptional.get();
//		} else {
//		}
//
//		model.addAttribute("computer", computer);
//		model.addAttribute("header", "Kompyuter redaktesi");
//
//		return "new-computer";
//	}

}
