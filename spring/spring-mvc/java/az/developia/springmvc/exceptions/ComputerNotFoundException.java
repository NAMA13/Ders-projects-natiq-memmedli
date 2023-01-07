package az.developia.springmvc.exceptions;

public class ComputerNotFoundException extends RuntimeException {
	public ComputerNotFoundException(String message) {
		super(message);
	}
}
