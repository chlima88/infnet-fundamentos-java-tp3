package domain;

import exceptions.NotaInvalidaException;
import util.Constants;

public class Aluno extends Pessoa {

	String matricula = Constants.NULL_STRING;
	float av1;
	float av2;
	
	
	public Aluno() {
		super();
	};
	
	public Aluno(String nome, String documento) {
		super(nome, documento);
	}
	
	
	public Aluno(String nome, String documento, String matricula) {
		this(nome, documento);
		this.matricula = matricula;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	};

	public float getAv1() {
		return this.av1;
	}

	public void setAv1(float av1) throws NotaInvalidaException {
		this.validateAV(av1);
		this.av1 = av1;
	}

	public float getAv2() {
		return this.av2;
	}

	public void setAv2(float av2) throws NotaInvalidaException {
		this.validateAV(av2);
		this.av2 = av2;
	}
	
    private void validateAV(float av) throws NotaInvalidaException {
        if (av < 0 || av > 10) {
            throw new NotaInvalidaException("Nota Invalida [" + av + "]: Deve ser entre 0 e 10");
        } 
    }
    
    public float calcularMedia() {
    	return ( this.av1 + this.av2 ) / 2;
    }
	
	public String consultarSituacao() {
		return this.toString();
	}
	
	@Override
	public String toString() {
		return super.toString() + ", " +
				"matricula: " + this.matricula + ", " +
				"av1: " + this.av1 + ", " +
				"av2: " + this.av2;
	}
}

