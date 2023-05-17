package project1.exceptions;

@SuppressWarnings("serial")
public class InvalidArgumentException extends Exception {
	public InvalidArgumentException(String message) {
		super(message);
	}
}
