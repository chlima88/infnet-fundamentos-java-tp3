package exceptions;

public class NotaInvalidaException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public NotaInvalidaException(String message) {
		super("\r\n[ERRO] " + message);
	}
	
}
