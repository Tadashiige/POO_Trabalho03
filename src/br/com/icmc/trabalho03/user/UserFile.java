package br.com.icmc.trabalho03.user;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class UserFile {
	final static private String fileName = "userData.csv";
	
	public UserFile(){		
	}
	
	
	private static ArrayList<User> readFile (BufferedReader in){		
		
		ArrayList<User> userList = new ArrayList<User>();
    	String csv;
        try {
			while((csv = in.readLine()) != null) {
			    userList.add(UserParser.parse(csv));
			}
			in.close();
		} catch (IOException e) {
			System.out.println("Error reading the file!");
		}
        return userList;
	}
	
	//le a coleção de usuários do arquivo
	public static ArrayList<User> loadFile (){		
		 
		BufferedReader in = null;
		
		//tentar abrir arquivo. Caso não encontre criar um novo.
	    try {
	        in = new BufferedReader(new FileReader(fileName));	        
	    }
	    
	    catch(FileNotFoundException e) {
	        try {
				new PrintWriter(new FileWriter(fileName)).close();
				in = new BufferedReader(new FileReader(fileName));
			} catch (IOException e1) {
				System.out.println("Error creating the file!");
			}
	    }
	    
	    return readFile(in);
	    	   
	}
	
	
	//salva coleção de usuários no arquivo
	public static void writeFile (ArrayList<User> userList){
		try {
			PrintWriter out = new PrintWriter(new FileWriter(fileName));
			userList
				.stream()
				.forEach(user -> out.println(user));
			out.close();
		}
	    catch(IOException e) {
	        System.out.println("Error writing the file!");
	    }
	}
   
}
