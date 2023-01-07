package az.developia.springmvc.advices;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import az.developia.springmvc.exceptions.ComputerNotFoundException;

@ControllerAdvice
public class MyExceptionHandler {
	@ExceptionHandler
	public String handleNotFound(ComputerNotFoundException exc,Model m) {
		m.addAttribute("message",exc.getMessage());
		return "my-message";
	}
}
