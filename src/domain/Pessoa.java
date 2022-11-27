package domain;


import util.Constants;

public abstract class Pessoa {
	 
	private String nome = Constants.NULL_STRING;
	private String nomeDoMeio = "";
	private String sobrenome = "";
	private String documento = Constants.NULL_STRING;
	
	public Pessoa() {}
	
	public Pessoa(String nomeCompleto, String documento){
		this.setNome(nomeCompleto);
		this.setNomeDoMeio(nomeCompleto);
		this.setSobrenome(nomeCompleto);
		this.documento = documento;
	}

	public String getNome() {
		return this.nome;
	}

	private void setNome(String nomeCompleto) {
		this.nome = Constants.capitalize(nomeCompleto.trim().split(" ")[0]);
	}
	
	public String getSobrenome() {
		return this.sobrenome;
	}

	private void setSobrenome(String nomeCompleto) {
		try {
			String trimmedNomeCompleto = nomeCompleto.trim();
			this.sobrenome = Constants.capitalize(
					trimmedNomeCompleto
					.substring(trimmedNomeCompleto.lastIndexOf(" "))
					.trim()
					);
		} catch (IndexOutOfBoundsException e) {
			this.sobrenome = "";
		}
	}

	public String getNomeDoMeio() {
		return this.nomeDoMeio;
	}

	private void setNomeDoMeio(String nomeCompleto) {
		try {
			String trimmedNomeCompleto = nomeCompleto.trim();
			this.nomeDoMeio = Constants.capitalize(
					trimmedNomeCompleto.substring(
							trimmedNomeCompleto.indexOf(" "),
							trimmedNomeCompleto.lastIndexOf(" ")
							)
					);
		} catch (IndexOutOfBoundsException e) {
			this.nomeDoMeio = "";
		}
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}
	
	public StringBuilder getNomeCompleto() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.nome);
		if (this.getNomeDoMeio() != "") sb.append(" ");
		sb.append(this.nomeDoMeio);
		if (this.getSobrenome() != "") sb.append(" ");
		sb.append(this.sobrenome);
		
		return sb;
	}
	
	public void setNomeCompleto(String nomeCompleto) {
		this.setNome(nomeCompleto);
		this.setNomeDoMeio(nomeCompleto);
		this.setSobrenome(nomeCompleto);
	}
	
	
	public abstract String consultarSituacao();
	
	@Override
	public String toString() {
		return "nome: " + this.getNomeCompleto() + ", " +
				"documento: " + this.documento; 
	}
	
}
