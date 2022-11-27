package domain;

import util.Constants;

public class Professor extends Pessoa {
	
	private String disciplina = Constants.NULL_STRING;
	
	public Professor(){
		super();
	}
	
	public Professor(String nome, String documento) {
		super(nome, documento);
	}
	
	public Professor(String nome, String documento, String disciplina) {
		super(nome, documento);
		this.disciplina = disciplina;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	
	public String consultarSituacao(){
		return toString();
	}
	
	@Override
	public String toString() {
		return super.toString() + ", " +
				"disciplina: " + this.disciplina;
	}
    
}
