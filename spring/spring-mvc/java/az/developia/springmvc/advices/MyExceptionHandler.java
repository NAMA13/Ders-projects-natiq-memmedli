package az.developia.springmvc.advices;

import org.springframework.security.access.AccessDeniedException;
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
	
	@ExceptionHandler
	public String handleNotFound(AccessDeniedException exc, Model m) {
		m.addAttribute("message", "Bu sehifeye huququn yoxdur");
		return "my-message";
	}
	
}
