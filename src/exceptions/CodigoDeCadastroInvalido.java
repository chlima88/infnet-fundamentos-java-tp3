package exceptions;

public class CodigoDeCadastroInvalido extends Exception {

	private static final long serialVersionUID = 1L;
	
	public CodigoDeCadastroInvalido(String mensagem) {
		super("\r\n[ERRO] " + mensagem);
	}
	

}
