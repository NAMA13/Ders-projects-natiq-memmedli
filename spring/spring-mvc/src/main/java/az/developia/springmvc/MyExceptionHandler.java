package az.developia.springmvc;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {
	@ExceptionHandler
	public String handleNotFound(StudentNotFoundException exc,Model m) {
		m.addAttribute("message",exc.getMessage());
		return "my-message";
	}
}
