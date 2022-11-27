package tp3;

import domain.Aluno;
import domain.Pessoa;
import domain.Professor;
import exceptions.CodigoDeCadastroInvalido;
import exceptions.NotaInvalidaException;
import exceptions.TamanhoMaximoDBException;
import util.Constants;

class Program {

    private static String choice = "0";

    private static Pessoa[] pessoasDb = new Pessoa[Constants.MAX_DB_SIZE];

    public static void main(String[] args) {

    	try {
	        do {
	            showMenu();
	            readChoice();
	            processChoice();
	        } while (!"5".equals(choice));

    	} catch (CodigoDeCadastroInvalido e) {
    		System.out.println(e.getMessage());
    	} catch (TamanhoMaximoDBException e) {
    		System.out.println(e.getMessage());
    	} finally {
    		System.out.print("[SUCESSO] Programa finalizado.");
    		Constants.STDIN.close();
    	}

    }

    private static void showMenu() {
        System.out.println("\r\n--------------------------------");
        System.out.println("[1] Cadastrar professor");
        System.out.println("[2] Cadastrar aluno.");
        System.out.println("[3] Consultar situação de um docente/discente.");
        System.out.println("[4] Listar todos os cadastros.");
        System.out.println("[5] Sair.");

    }

    private static void readChoice() {
        System.out.print("\r\nSua opcao: ");
        choice = Constants.STDIN.next();
    }

    private static void processChoice() throws CodigoDeCadastroInvalido, TamanhoMaximoDBException {
    	
        if ("1".equals(choice))
        	addPerson("professor");
        else if ("2".equals(choice))
        	addPerson("aluno");
        else if ("3".equals(choice))
            findPerson();
        else if ("4".equals(choice))
        	listAllPerson();
        else if (!"5".equals(choice))
            System.out.println("[ERRO] Opcao invalida!");

    }
    
    private static void addPerson(String type) throws TamanhoMaximoDBException {
    	
    	int id = getNewId();
    	String nomeCompleto;
    	String documento;
    	
        System.out.print("Informe o nome do " + type + ": ");
        Constants.STDIN.nextLine();
        nomeCompleto = Constants.STDIN.nextLine();
        
        System.out.print("Informe o documento do " + type + ": ");
        documento = Constants.STDIN.next();
        
        switch(type.toLowerCase()) {
	        case "aluno":
	            System.out.print("Informe a matricula do Aluno: ");
	        	String matricula = Constants.STDIN.next();
	        	Aluno aluno = new Aluno(nomeCompleto, documento, matricula);  
	        	
	        	do {		        		
	        		try {
		        		System.out.print("Informe a nota da AV1: ");
			        	float av1 = Constants.STDIN.nextFloat();
			        	aluno.setAv1(av1);
			        	
			            System.out.print("Informe a nota da AV2: ");
			        	float av2 = Constants.STDIN.nextFloat();
			        	aluno.setAv2(av2);
			        	
			        	break;
			        			
	        		} catch (NotaInvalidaException e) {
	        			System.out.println(e.getMessage());
	        		}		
	        		
	        	} while(true);
	        	
	            savePerson(id, aluno);
	        	break;
	        	
	        case "professor":
	            System.out.print("Informe a disciplina do Professor: ");
	            Constants.STDIN.nextLine();
	            String disciplina = Constants.STDIN.nextLine();
	            Professor professor = new Professor(nomeCompleto, documento, disciplina);
	            savePerson(id, professor);
	        	break;
	        	
        }
    	
        System.out.println("\r\n[SUCESSO] Cadastro concluido!");
        System.out.println("[INFO] Codigo do cadastro: " + id);
        
    	return;
    }
    
    private static void findPerson() throws CodigoDeCadastroInvalido {
    	
    	System.out.print("Informe o codigo do cadastro: ");
        int id = Integer.valueOf(Constants.STDIN.nextInt());
        
        try {
        	if (id >= Constants.MAX_DB_SIZE) 
            	throw new CodigoDeCadastroInvalido("Codigo Invalido!");
        	if (pessoasDb[id] == null ) 
        		throw new CodigoDeCadastroInvalido("Codigo Inexistente!");
        	
        	System.out.println(pessoasDb[id].toString());
        	
        } catch(CodigoDeCadastroInvalido e) {
        	System.out.println(e.getMessage());
        }
    
    }
    	
    private static void listAllPerson() {
    	
    	int index = 0;
    	
    	for (Pessoa pessoa: pessoasDb) {
    		if (pessoa == null) break;
    		index++;
    		System.out.println("[" + index + "] " + pessoa.toString());
    	}
    }

    private static int getNewId() throws TamanhoMaximoDBException {
        int i = 0;
        while (pessoasDb[i] != null) {
            if (i + 1 < Constants.MAX_DB_SIZE) {
                i++;
            } else {
            	throw new TamanhoMaximoDBException("Tamanho maximo do DB alcancado.");
            }
        }

        return i;
    }

    private static void savePerson(int id, Pessoa pessoa) {
        pessoasDb[id] = pessoa;
    }


}