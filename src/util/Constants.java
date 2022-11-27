package util;

import java.util.Scanner;

public class Constants {

    public static final Scanner STDIN = new Scanner(System.in);
    
    
	public final static String NULL_STRING = "Não informado";
	
	public static final int MAX_DB_SIZE = 100;
	
	public static String capitalize(String text) {
		
		String capitalizedWord = "";
	    for(String word: text.trim().split(" ")){
	    	if (word != "") capitalizedWord +=  word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase() + " ";
	    }
		return capitalizedWord.trim();
		
	}
}
