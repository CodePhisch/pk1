package praktikum8.exceptions;

public class EmptyFilenameException extends Exception {

	private static final long serialVersionUID = 1L;

	public EmptyFilenameException() {
		super();
	}
	
	public EmptyFilenameException(String message) {
		super(message);
	}
	
}
