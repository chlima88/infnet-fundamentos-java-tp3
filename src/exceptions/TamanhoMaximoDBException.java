package exceptions;

public class TamanhoMaximoDBException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public TamanhoMaximoDBException(String mensagem) {
		super("\r\n[ERRO] " + mensagem);
	}
	

}
