package tests;

import domain.Aluno;
import domain.Professor;
import exceptions.NotaInvalidaException;

public class Tests {
	
	private static String nome1 = "First";
	private static String nome2 = "Second User";
	private static String nome3 = "Third user name";
	private static String nome4 = "  CHARLES de     jESUS lImA da costa ";
	private static String documento = "99999999999";
	private static String matricula = "100";
	private static String disciplina = "Fisica Quântica";
	
	public static void main(String[] args) {
		
		InstanciarObjetosTest();
		AtribuirAvTest();
		FormatarNomeTest();

	}
	
	public static void InstanciarObjetosTest() {
		
		System.out.println("# Test 1 #");
		
		System.out.println("\r\n- Teste 1.1: Instanciar 'Aluno' e 'Professor' com todos os argumentos informados no construtor\r\n"
				+ "\r\n  Resultados esperados:\r\n"
				+ "  + Objeto instanciado corretamente\r\n"
				+ "  + Todos os atributos exibidos corretamente\r\n"
				+ "\r\n  Resultado:");		
		
		Aluno aluno1 = new Aluno(nome1, documento, matricula);
		System.out.println("  aluno: '" + aluno1.toString() + "'");
		
		Professor professor1 = new Professor(nome1, documento, disciplina);
		System.out.println("  professor: '" + professor1.toString() + "'");
		
		
		System.out.println("\r\n- Teste 1.2: Instanciar o aluno apenas com o 'nome' "
				+ "e 'documento' e definir os demais atributos com os metodos setters\r\n"
				+ "\r\n  Resultados esperados:\r\n"
				+ "  + Objeto instanciado corretamente\r\n"
				+ "  + Todos os atributos exibidos corretamente\r\n"
				+ "\r\n  Resultado:");
		
		Aluno aluno2 = new Aluno(nome2, documento);
		aluno2.setMatricula(matricula);
		System.out.println("  aluno: '" + aluno2.toString() + "'");
		
		Professor professor2 = new Professor(nome2, documento);
		professor2.setDisciplina(disciplina);
		System.out.println("  professor: '" + professor2.toString() + "'");
	
		
		System.out.println("\r\n- Teste 1.3: Instanciar aluno sem parametros e defini-los um a um manualmente\r\n"
				+ "\r\n  Resultados esperados:\r\n"
				+ "  + Objeto instanciado corretamente\r\n"
				+ "  + Todos os atributos exibidos corretamente\r\n"
				+ "\r\n  Resultado:");
		
		Aluno aluno3 = new Aluno();
		aluno3.setNomeCompleto(nome3);
		aluno3.setDocumento(documento);
		aluno3.setMatricula(matricula);
		try {
			aluno3.setAv1(10);
			aluno3.setAv2(10);
		} catch(NotaInvalidaException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("  aluno: '" + aluno3.toString() + "'");
		
	}
	
	public static void AtribuirAvTest() {
		/* Permite apenas notas AV1 e AV2 validas */
		
		System.out.println("\r\n# Test 2 #");
		
		System.out.println("\r\n- Teste 2.1: Atribuir uma nota menor que 0 a 'av1'\r\n"
				+ "\r\n  Resultados esperados:\r\n"
				+ "  + Lançar uma exceção\r\n"
				+ "  + Exibir uma mensagem de erro\r\n"
				+ "\r\n  Resultado:");
		
		Aluno aluno = new Aluno(nome3, documento);
		try {
			aluno.setAv1(-1);
		} catch(NotaInvalidaException e) {
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("\r\n- Teste 2.2: Atribuir uma nota maior que 10 a 'av1'\r\n"
				+ "\r\n  Resultados esperados:\r\n"
				+ "  + Lançar uma exceção\r\n"
				+ "  + Exibir uma mensagem de erro\r\n"
				+ "\r\n  Resultado:");
		
		try {
			aluno.setAv1(11);
		} catch(NotaInvalidaException e) {
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("\r\n- Teste 2.3: Atribuir uma nota menos que 0 a 'av2'\r\n"
				+ "\r\n  Resultados esperados:\r\n"
				+ "  + Lançar uma exceção\r\n"
				+ "  + Exibir uma mensagem de erro\r\n"
				+ "\r\n  Resultado:");
		
		try {
			aluno.setAv2(-1);
		} catch(NotaInvalidaException e) {
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("\r\n- Teste 2.4: Atribuir uma nota maior que 10 a 'av2'\r\n"
				+ "\r\n  Resultados esperados:\r\n"
				+ "  + Lançar uma exceção\r\n"
				+ "  + Exibir uma mensagem de erro\r\n"
				+ "\r\n  Resultado:");
		
		try {
			aluno.setAv2(11);
		} catch(NotaInvalidaException e) {
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("\r\n- Teste 2.5: Atribuir uma nota maior que 10 a 'av1' e 'av2'\r\n"
				+ "\r\n  Resultados esperados:\r\n"
				+ "  + Objeto criado corretamente\r\n"
				+ "  + Atributos av1 e av2 corretamente exibidos\r\n"
				+ "\r\n  Resultado:");
		
		try {
			aluno.setAv1(10);
			aluno.setAv2(10);
		} catch(NotaInvalidaException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("  aluno: '" + aluno.toString() + "'");

	}

	public static void FormatarNomeTest() {
		/* Testa a utilização de diferentes formatos de nomeCompleto */
		
		System.out.println("\r\n# Teste 3 # ");
		
		System.out.println("\r\n- Teste 3.1: Criar instancia usando o nome ["+ nome1 +"]\r\n"
				+ "\r\n  Resultados esperados:\r\n"
				+ "  + Objeto instanciado corretamente.\r\n"
				+ "  + Todas as propriedades exceto [nomeDoMeio] e [sobrenome] estarão preenchidas\r\n"
				+ "\r\n  Resultado:");
		
		Aluno aluno1 = new Aluno(nome1, documento, matricula);
		
		System.out.println("  aluno: '" + aluno1.consultarSituacao() + "'\r\n"
						+ "  aluno.nome: '" + aluno1.getNome() + "'\r\n"
						+ "  aluno.nomeDoMeio: '" + aluno1.getNomeDoMeio() + "'\r\n"
						+ "  aluno.sobrenome: '" + aluno1.getSobrenome() + "'\r\n");
		
		
		System.out.println("\r\n- Teste 3.2: Criar instancia usando o nome ["+ nome2 +"]\r\n" 
				+ "\r\n  Resultados esperados:\r\n"
				+ "  + Objeto instanciado corretamente.\r\n"
				+ "  + Todas as propriedades exceto [nomeDoMeio] estarão preenchidas\r\n"
				+ "\r\n  Resultado:");
		
		Aluno aluno2 = new Aluno(nome2, documento, matricula);
		
		System.out.println("  aluno: '" + aluno2.consultarSituacao() + "'\r\n"
				+ "  aluno.nome: '" + aluno2.getNome() + "'\r\n"
				+ "  aluno.nomeDoMeio: '" + aluno2.getNomeDoMeio() + "'\r\n"
				+ "  aluno.sobrenome: '" + aluno2.getSobrenome() + "'\r\n");

		
		System.out.println("\r\n- Teste 3.3: Criar instancia usando o nome ["+ nome3 +"]\r\n"
				+ "\r\n  Resultados esperados:\r\n"
				+ "  + Objeto instanciado corretamente.\r\n"
				+ "  + Todas as propriedades estarão preenchidas\r\n"
				+ "\r\n  Resultado:");
		
		Aluno aluno3 = new Aluno(nome3, documento, matricula);
		
		System.out.println("  aluno: '" + aluno3.consultarSituacao() + "'\r\n"
				+ "  aluno.nome: '" + aluno3.getNome() + "'\r\n"
				+ "  aluno.nomeDoMeio: '" + aluno3.getNomeDoMeio() + "'\r\n"
				+ "  aluno.sobrenome: '" + aluno3.getSobrenome() + "'\r\n");
		
		
		System.out.println("\r\n- Teste 3.4: Criar instancia e, posteriormente, definir o nome ["+ nome4 +"]\r\n"
				+ "\r\n  Resultados esperados:\r\n"
				+ "  + Objeto instanciado corretamente.\r\n"
				+ "  + Todas as propriedade estarão preenchidas\r\n"
				+ "  + As propriedades relacionadas ao nome estão formatadas com as primeiras letras em maiusculo\r\n"
				+ "\r\n  Resultado:");
		
		Aluno aluno4 = new Aluno();
		aluno4.setNomeCompleto(nome4);
		
		System.out.println("  aluno: '" + aluno4.consultarSituacao() + "'\r\n"
				+ "  aluno.nome: '" + aluno4.getNome() + "'\r\n"
				+ "  aluno.nomeDoMeio: '" + aluno4.getNomeDoMeio() + "'\r\n"
				+ "  aluno.sobrenome: '" + aluno4.getSobrenome() + "'\r\n\r\n\r\n\r\n");
		
	}
	
}
