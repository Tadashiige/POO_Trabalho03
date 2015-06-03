package br.com.icmc.trabalho03.book;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class BookFile {
	final static private String fileName = "bookData.csv";
	
	public BookFile(){		
	}
	
	
	private static ArrayList<Book> readFile (BufferedReader in){		
		
		ArrayList<Book> bookList = new ArrayList<Book>();
    	String csv;
        try {
			while((csv = in.readLine()) != null) {
			    bookList.add(BookParser.parse(csv));
			}
			in.close();
		} catch (IOException e) {
			System.out.println("Error reading the file!");
		}
        return bookList;
	}
	
	//le a coleção de book do arquivo
	public static ArrayList<Book> loadFile (){		
		 
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
	
	
	//salva coleção de book no arquivo
	public static void writeFile (ArrayList<Book> bookList){
		try {
			PrintWriter out = new PrintWriter(new FileWriter(fileName));
			bookList
				.stream()
				.forEach(book -> out.println(book));
			out.close();
		}
	    catch(IOException e) {
	        System.out.println("Error writing the file!");
	    }
	}
   
}
