package exception;

public class NotValidException extends Exception {
	private static final long serialVersionUID = 6643970280801050465L;

	public NotValidException() {
		super();
	}

	public NotValidException(String message) {
		super(message);
	}
}
