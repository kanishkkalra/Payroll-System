package project;

public class InvalidSINException extends Exception {
	
	// no argument constructor. Defaults message
	public InvalidSINException() {
		super("ERROR: Invalid SIN number provided");
	}
	
	// one argument constructor. Message si passed as argument
	public InvalidSINException(String message) {
		super(message);
	}
}
