package objects;

public class InputException extends Exception {
	private String message;

	public InputException(String error) {
		
		this.message = error;
	}

	public String getMessage() {
		return message;
	}
	
	

}
